package com.itacademy.jd2.is.carsharing.service.impl;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.itacademy.jd2.is.carsharing.dao.api.ICustomerDao;
import com.itacademy.jd2.is.carsharing.dao.api.IUserAccountDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.filter.UserAccountFilter;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;

@Service
@PropertySource("classpath:aws.properties")
public class UserAccountServiceImpl implements IUserAccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountServiceImpl.class);
	private IUserAccountDao dao;
	private ICustomerDao customerDao;
	@Value("${aws.access.key}")
	private String accessKey;
	@Value("${aws.secret.key}")
	private String secretKey;

	@Autowired
	public UserAccountServiceImpl(IUserAccountDao dao, ICustomerDao customerDao) {
		super();
		this.dao = dao;
		this.customerDao = customerDao;
	}

	@Override
	public IUserAccount createEntity() {
		return dao.createEntity();
	}
	
	public ICustomer createCustomerEntity() {
		return customerDao.createEntity();
	}

	@Override
	public IUserAccount get(Integer id) {
		final IUserAccount entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IUserAccount> getAll() {
		final List<IUserAccount> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IUserAccount entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new user account created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("user account updated" + entity);
			dao.update(entity);
		}
	}

	@Override
	public void save(IUserAccount entity, ICustomer customer) {
		final Date modifedDate = new Date();
		entity.setUpdated(modifedDate);
		customer.setUpdated(modifedDate);
		if (entity.getId() == null) {
			LOGGER.info("new user account created" + entity);
			entity.setCreated(modifedDate);
			String plainPass = entity.getPassword();
			String hashed = BCrypt.hashpw(plainPass, BCrypt.gensalt(12));
			entity.setPassword(hashed);
			dao.insert(entity);
			
			
			
			customer.setId(entity.getId());
			customer.setCreated(modifedDate);
			customer.setUserAccount(entity);
			customerDao.insert(customer);
			
			entity.setCustomer(customer);
		} else {
			LOGGER.info("user account updated" + entity);
			dao.update(entity);
			customerDao.update(customer);
		}
	}
	
	@Override
	public void save(IUserAccount entity, ICustomer customer, String fileName, InputStream file) {
		final Date modifedDate = new Date();
		entity.setUpdated(modifedDate);
		customer.setUpdated(modifedDate);
		if (entity.getId() == null) {
			LOGGER.info("new user account created" + entity);
			entity.setCreated(modifedDate);
			String plainPass = entity.getPassword();
			String hashed = BCrypt.hashpw(plainPass, BCrypt.gensalt(12));
			entity.setPassword(hashed);
			dao.insert(entity);
			
			
			final BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,
					secretKey);
			final AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-1")
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
			final String bucketName = entity.getCustomer().getLastName().toLowerCase() + UUID.randomUUID();
			s3Client.createBucket(bucketName);
			try {
				s3Client.putObject(
						new PutObjectRequest(bucketName, fileName, file, new ObjectMetadata())
								.withCannedAcl(CannedAccessControlList.PublicRead));
			} catch (final Exception e) {
				e.printStackTrace();
			}
			final S3Object driverLicense = s3Client
					.getObject(new GetObjectRequest(bucketName, fileName));
			final String driverLicensePath = driverLicense.getObjectContent().getHttpRequest().getURI().toString();
			entity.getCustomer().setDriverLicense(driverLicensePath);
			
			
			customer.setId(entity.getId());
			customer.setCreated(modifedDate);
			customer.setUserAccount(entity);
			customerDao.insert(customer);
			
			entity.setCustomer(customer);
		} else {
			LOGGER.info("user account updated" + entity);
			dao.update(entity);
			customerDao.update(customer);
		}
	}


	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public IUserAccount getByLogin(String login) {
		IUserAccount theUser = dao.createEntity();
		for (IUserAccount users : getAll()) {
			if (users.getLogin().equals(login)) {
				theUser = users;
			}
		}
		return theUser;
	}

	public void encryptPass(String pass) {
		String algorithm = "SHA";

		byte[] plainText = pass.getBytes();

		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);

			md.reset();
			md.update(plainText);
			byte[] encodedPassword = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < encodedPassword.length; i++) {
				if ((encodedPassword[i] & 0xff) < 0x10) {
					sb.append("0");
				}

				sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<IUserAccount> find(UserAccountFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(UserAccountFilter filter) {
		return dao.getCount(filter);
	}

}
