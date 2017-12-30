package com.javaInterview.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaInterview.encryptor.Encryptor;
import com.javaInterview.pojo.Hashes;
import com.javaInterview.service.HashService;

/**
 * <h1>Java Project Body Building <br/>
 * </h1>
 * 
 * <p>
 * Service Entity Implementation <br/>
 * This class implements the business logic of the Service Entity.
 * </p>
 *
 * @author Daniyal Saeed
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */

@Service
public class HashServiceImpl implements HashService {

	@Autowired
	Encryptor encrypt;

	@Override
	public List<Hashes> encrypt(String[] strings, String hashType) {

		List<Hashes> hashList = new ArrayList<>();
		try {
			for (int i = 0; i < strings.length; i++) {
				Hashes hash = new Hashes();
				hash.setStrings(strings[i]);
				hash.setMd5(encrypt.getEncryption(strings[i], hashType));
				hashList.add(hash);

			}
		} catch (Exception e) {
			System.out.println("Exception = " + e.toString());

		}
		return hashList;
	}

	@Override
	public List<Hashes> encryptAll(String[] strings) {

		List<Hashes> hashList = new ArrayList<>();
		if (strings != null) {

			try {
				for (int i = 0; i < strings.length; i++) {

					hashList.add(new Hashes(strings[i], encrypt.getEncryption(strings[i], "MD5"),
							encrypt.getEncryption(strings[i], "SHA1"), encrypt.getEncryption(strings[i], "SHA-256"),
							encrypt.getEncryption(strings[i], "SHA-512")));
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return hashList;

	}

}
