package com.itacademy.jd2.is.carsharing.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	private final ICustomerService customerService;
	private final CustomerFromDTOConverter customerFromDtoConverter;
	private final CustomerToDTOConverter customerToDtoConverter;

	@Autowired
	public RegistrationController(ICustomerService customerService, CustomerFromDTOConverter customerFromDtoConverter,
			CustomerToDTOConverter customerToDtoConverter) {
		super();
		this.customerService = customerService;
		this.customerFromDtoConverter = customerFromDtoConverter;
		this.customerToDtoConverter = customerToDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final ICustomer newCustomer = customerService.createEntity();
		hashMap.put("formModel", customerToDtoConverter.apply(newCustomer));

		return new ModelAndView("registration", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrate(@RequestParam MultipartFile[] files,
			@Valid @ModelAttribute("formModel") CustomerDTO formCustomer, final BindingResult result)
			throws IOException {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final ICustomer customer = customerFromDtoConverter.apply(formCustomer);
			final BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIAJBFM4F4TYLTU3PNA",
					"LQ0vdmLtaMTgjbrTmtk8YjEAUm0IOUFNmS66I3yC");
			final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
			final String bucketName = customer.getUserAccount().getLogin();
			s3Client.createBucket(bucketName);
			try {
				final InputStream driverLicenseIS = files[0].getInputStream();
				final InputStream passportIS = files[1].getInputStream();
				final InputStream imageIS = files[2].getInputStream();

				s3Client.putObject(new PutObjectRequest(bucketName, files[0].getOriginalFilename(), driverLicenseIS,
						new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));
				s3Client.putObject(new PutObjectRequest(bucketName, files[1].getOriginalFilename(), passportIS,
						new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));
				s3Client.putObject(
						new PutObjectRequest(bucketName, files[2].getOriginalFilename(), imageIS, new ObjectMetadata())
								.withCannedAcl(CannedAccessControlList.PublicRead));
			} catch (final Exception e) {
				e.printStackTrace();
			}
			final S3Object drivLicense = s3Client
					.getObject(new GetObjectRequest(bucketName, files[0].getOriginalFilename()));
			final String driverLicensePath = drivLicense.getObjectContent().getHttpRequest().getURI().toString();
			final S3Object passport = s3Client
					.getObject(new GetObjectRequest(bucketName, files[1].getOriginalFilename()));
			final String passportPath = passport.getObjectContent().getHttpRequest().getURI().toString();
			final S3Object image = s3Client.getObject(new GetObjectRequest(bucketName, files[2].getOriginalFilename()));
			final String imagePath = image.getObjectContent().getHttpRequest().getURI().toString();
			customer.setDriverLicense(driverLicensePath);
			customer.setCustomerPassport(passportPath);
			customer.setCustomerImage(imagePath);
			customerService.save(customer);
			return "redirect:/index";
		}

	}

}
