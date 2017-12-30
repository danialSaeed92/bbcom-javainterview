package com.javaInterview.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javaInterview.pojo.Hashes;

import com.javaInterview.service.HashService;

/**
 * <h1>Java Project Body Building <br/>
 * </h1>
 * 
 * <p>
 * Controller <br/>
 * Controller Class provides the URL mapping and is responsible to call the
 * encryption methods of the service.
 * </p>
 *
 * @author Daniyal Saeed
 * 
 * @version 2.0.0
 * @since 1.0.0
 * 
 */

@RestController
public class HashController {

	@Autowired
	HashService messageService;
	
	public static final String URL = "/hash/{hashType}";

	@SuppressWarnings("unchecked")
	@RequestMapping(value = URL, method = RequestMethod.POST)
	public ResponseEntity<JSONObject> encrypt(@RequestBody String strings, @PathVariable String hashType) {

		List<Hashes> messages = new ArrayList<>();
		JSONObject jObject = new JSONObject();
		String[] string = { "" };
		JSONParser parser = new JSONParser();

		if (strings != null) {

			try {
				JSONObject json = (JSONObject) parser.parse(strings);
				String jsonStringArray = json.get("strings").toString();

				Gson converter = new Gson();
				Type type = new TypeToken<List<String>>() {
				}.getType();
				List<String> list = converter.fromJson(jsonStringArray, type);
				string = list.toArray(new String[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (hashType.equals("all")) {
				messages = messageService.encryptAll(string);
			} else {
				if (hashType.equals("sha256")) {
					hashType = "sha-256";
				}
				if (hashType.equals("sha512")) {
					hashType = "sha-512";
				}
				messages = messageService.encrypt(string, hashType);
			}
		}
		jObject.put("Hashes", messages);
		return new ResponseEntity<JSONObject>(jObject, HttpStatus.OK);

	}

}
