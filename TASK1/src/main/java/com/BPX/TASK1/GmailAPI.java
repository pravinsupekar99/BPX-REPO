package com.BPX.TASK1;



	import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
	import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
	import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
	import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
	import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
	import com.google.api.client.http.HttpTransport;
	import com.google.api.client.json.JsonFactory;
	import com.google.api.client.json.jackson2.JacksonFactory;
	import com.google.api.client.util.Base64;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.api.services.gmail.Gmail;
	import com.google.api.services.gmail.GmailScopes;
	import com.google.api.services.gmail.model.ListMessagesResponse;
	import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePartHeader;

import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.List;

	public class GmailAPI {

	    private static final String APPLICATION_NAME = "Gmail API Example";
	    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	    private static HttpTransport httpTransport;

	    // Location of client_secrets.json file (downloaded from Google Developer Console)
	    private static final String CLIENT_SECRET_LOCATION = "/path/to/client_secrets.json";

	    public static void main(String[] args) throws Exception {
	        httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	        Gmail service = getGmailService();

	        String user = "me";
	        List<Message> messages = listMessages(service, user, 200);

	        if (messages.isEmpty()) {
	            System.out.println("No messages found.");
	        } else {
	            System.out.println("Sender\t\t\tSubject");
	            System.out.println("-----------------------------------------------");
	            for (Message message : messages) {
	                String sender = getHeader(message, "From");
	                String subject = getHeader(message, "Subject");
	                System.out.println(sender + "\t\t" + subject);
	            }
	        }
	    }

	    private static Gmail getGmailService() throws IOException {
	        InputStream in = GmailAPI.class.getResourceAsStream(CLIENT_SECRET_LOCATION);
	        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

	        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	                httpTransport, JSON_FACTORY, clientSecrets, GmailScopes.all())
	                .setDataStoreFactory(new MemoryDataStoreFactory())
	                .setAccessType("offline")
	                .build();

	        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
	                .authorize("user");

	        return new Gmail.Builder(httpTransport, JSON_FACTORY, credential)
	                .setApplicationName(APPLICATION_NAME)
	                .build();
	    }

	    private static List<Message> listMessages(Gmail service, String userId, int count) throws IOException {
	        List<Message> messages = new ArrayList<>();
	        ListMessagesResponse response = service.users().messages().list(userId).setMaxResults((long) count).execute();
	        if (response.getMessages() != null) {
	            messages.addAll(response.getMessages());
	        }
	        return messages;
	    }

	    private static String getHeader(Message message, String headerName) {
	        List<MessagePartHeader> headers = message.getPayload().getHeaders();
	        for (MessagePartHeader header : headers) {
	            if (headerName.equals(header.getName())) {
	                return header.getValue();
	            }
	        }
	        return "";
	    }
	}


