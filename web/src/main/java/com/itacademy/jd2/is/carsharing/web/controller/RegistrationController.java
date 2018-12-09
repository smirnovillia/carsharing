package com.itacademy.jd2.is.carsharing.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;
import com.itacademy.jd2.is.carsharing.web.converter.UserAccountFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.UserAccountToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.UserAccountDTO;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	@Autowired
	private IUserAccountService userAccountService;
	@Autowired
	private UserAccountFromDTOConverter userAccountFromDtoConverter;
	@Autowired
	private UserAccountToDTOConverter userAccountToDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final UserAccountDTO dto = new UserAccountDTO();
		hashMap.put("formModel", dto);
		return new ModelAndView("registration", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrate(@RequestParam("file") MultipartFile file,
			@ModelAttribute("formModel") UserAccountDTO formModel, BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final IUserAccount user = userAccountFromDtoConverter.apply(formModel);
			final BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIAJBFM4F4TYLTU3PNA",
					"LQ0vdmLtaMTgjbrTmtk8YjEAUm0IOUFNmS66I3yC");
			final AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-1")
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
			final String bucketName = user.getCustomer().getLastName() + UUID.randomUUID();
			s3Client.createBucket(bucketName);
			try {

				final InputStream is = file.getInputStream();

				s3Client.putObject(
						new PutObjectRequest(bucketName, file.getOriginalFilename(), is, new ObjectMetadata())
								.withCannedAcl(CannedAccessControlList.PublicRead));
			} catch (final Exception e) {
				e.printStackTrace();
			}
			final S3Object driverLicense = s3Client
					.getObject(new GetObjectRequest(bucketName, file.getOriginalFilename()));
			final String driverLicensePath = driverLicense.getObjectContent().getHttpRequest().getURI().toString();
			user.getCustomer().setDriverLicense(driverLicensePath);
			userAccountService.save(user, user.getCustomer());
			return "redirect:/login";
		}

	}

}
