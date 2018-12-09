package com.itacademy.jd2.is.carsharing.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
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
	public String registrate(@RequestParam("file") MultipartFile file,
			@Valid @ModelAttribute("formModel") CustomerDTO formCustomer, final BindingResult result)
			throws IOException {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final ICustomer customer = customerFromDtoConverter.apply(formCustomer);
			final BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIAJBFM4F4TYLTU3PNA",
					"LQ0vdmLtaMTgjbrTmtk8YjEAUm0IOUFNmS66I3yC");
			final AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-1")
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
			final String bucketName = customer.getUserAccount().getLogin() + UUID.randomUUID();
			s3Client.createBucket(bucketName);
			try {
				
				InputStream is = file.getInputStream();
				
				s3Client.putObject(
						new PutObjectRequest(bucketName, file.getOriginalFilename(), is, new ObjectMetadata())
								.withCannedAcl(CannedAccessControlList.PublicRead));
			} catch (final Exception e) {
				e.printStackTrace();
			}
			final S3Object driverLicense = s3Client.getObject(new GetObjectRequest(bucketName, file.getOriginalFilename()));
			final String driverLicensePath = driverLicense.getObjectContent().getHttpRequest().getURI().toString();
			customer.setDriverLicense(driverLicensePath);
			customerService.save(customer);
			return "redirect:/index";
		}

	}

}
