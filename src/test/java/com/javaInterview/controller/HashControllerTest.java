package com.javaInterview.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javaInterview.Message.MessageApplication;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MessageApplication.class)
@WebMvcTest(HashController.class)
public class HashControllerTest {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
	 @Autowired
	 private WebApplicationContext context;
	 
	 public void setup() {
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	 }
	 
	 @Test 
	 public void hashControllerTestReturnOkStatusAndCorrectPayLoadMD5() throws Exception {
	 
		 
		 String hashType  = "MD5";
		 String responseBody ="{\r\n" + 
		 		"    \"strings\":[ \"this is string one\", \"this is string two\", \"this array can be arbitrarily long\"]\r\n" + 
		 		"}";
		 mockMvc.perform(post(HashController.URL,hashType).content(responseBody)).andExpect(status().isOk())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		 .andExpect(content().json("{\r\n" + 
		 		"    \"Hashes\": [\r\n" + 
		 		"        {\r\n" + 
		 		"            \"strings\": \"this is string one\",\r\n" + 
		 		"            \"md5\": \"a6c4059f07e8b467b52fb98134c5eea3\"\r\n" + 
		 		"        },\r\n" + 
		 		"        {\r\n" + 
		 		"            \"strings\": \"this is string two\",\r\n" + 
		 		"            \"md5\": \"6382d53e60487112b5398bc9faef4b0d\"\r\n" + 
		 		"        },\r\n" + 
		 		"        {\r\n" + 
		 		"            \"strings\": \"this array can be arbitrarily long\",\r\n" + 
		 		"            \"md5\": \"e53b4be3daea008c484aa6c63c988346\"\r\n" + 
		 		"        }\r\n" + 
		 		"    ]\r\n" + 
		 		"}",true))
		 .andDo(print())
		 .andReturn();
		 
	 }
	 
	 @Test 
	 public void hashControllerTestReturnOkStatusAndCorrectPayLoadAll() throws Exception {
	 
		 
		 String hashType  = "all";
		 String responseBody ="{\r\n" + 
		 		"    \"strings\":[ \"this is string one\", \"this is string two\", \"this array can be arbitrarily long\"]\r\n" + 
		 		"}";
		 mockMvc.perform(post(HashController.URL,hashType).content(responseBody)).andExpect(status().isOk())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		 .andExpect(content().json("{\r\n" + 
		 		"    \"Hashes\": [\r\n" + 
		 		"        {\r\n" + 
		 		"            \"strings\": \"this is string one\",\r\n" + 
		 		"            \"md5\": \"a6c4059f07e8b467b52fb98134c5eea3\",\r\n" + 
		 		"            \"sha1\": \"f4a70fdab1c954964c7ba6d81d4f2cd3699fa633\",\r\n" + 
		 		"            \"sha256\": \"df4203350093e44d2124a16d82e7f9f71dbf190f266a1945ddc047c2f5e43c7e\",\r\n" + 
		 		"            \"sha512\": \"a21063da356cdedc33c34a3d5a01beb90dd83706714f0a23e8dad80129c98d2fd3dbc55c669b64f31e8fbd46dc923dcf54cb20bfc3ee558af4ce356b7b6acf5\"\r\n" + 
		 		"        },\r\n" + 
		 		"        {\r\n" + 
		 		"            \"strings\": \"this is string two\",\r\n" + 
		 		"            \"md5\": \"6382d53e60487112b5398bc9faef4b0d\",\r\n" + 
		 		"            \"sha1\": \"ded10ea05294a36fa910ff66ecf3b70e79316a68\",\r\n" + 
		 		"            \"sha256\": \"e3dc398b12f77f2bef3481ec87a261efbf7658d631cfb1d179b3ce9a6cec60f0\",\r\n" + 
		 		"            \"sha512\": \"cf42f4e0a801e19c34cf446aaba773d4cb8f65075a42435c5b1ff4dacfc796be69fb88be4208ca837817db8aa5bf4036255c62e3df08fd421a08ba552d18a1cb\"\r\n" + 
		 		"        },\r\n" + 
		 		"        {\r\n" + 
		 		"            \"strings\": \"this array can be arbitrarily long\",\r\n" + 
		 		"            \"md5\": \"e53b4be3daea008c484aa6c63c988346\",\r\n" + 
		 		"            \"sha1\": \"1f08f22280b2a0962c37b05ae1177c50ee73cbfa\",\r\n" + 
		 		"            \"sha256\": \"911ae2e3fc0b2001b38d382d451699c6c9b1f80159f1a8c4c6581cbe3cc4c46c\",\r\n" + 
		 		"            \"sha512\": \"8bdd3245709c93f853947201cae9ab9f9570163ac446cd16d239df810cd591de24d4fd63f100c8b1dd2bcba00c04ebe2395ad0ef20b2a7c034fe670859da1c2\"\r\n" + 
		 		"        }\r\n" + 
		 		"    ]\r\n" + 
		 		"}",true))
		 .andDo(print())
		 .andReturn();
		 
	 }
	 
	
}
