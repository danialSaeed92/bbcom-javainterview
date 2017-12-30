package com.javaInterview.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaInterview.pojo.Hashes;

/**
 * <h1>Java Project Body Building  <br/>
 * </h1>
 * 
 * <p>
 * Service Entity<br/>
 * This service entity has two methods.
 * <ul>
 * <li>
 *  1st method is to encrypt the string with the provided encryption type.
 * </li>
 * <li>
 * 2nd method is to encrypt the string with all the provided encryption algorithms
 * </li>
 * </ul> 
 * 
 * </p>
 *
 * @author Daniyal Saeed
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */

@Service
public interface HashService {
	
	/**
	 * 
	 * @param strings
	 * @param hashType
	 * @return List of strings along with their encryption according to their encryption type
	 */
	public List<Hashes> encrypt(String[] strings, String hashType);
	
	/**
	 * 
	 * @param strings
	 * @return List of strings with all the encryption methods
	 */
	public List<Hashes> encryptAll(String[] strings);
}
