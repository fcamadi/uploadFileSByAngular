package org.fran.upload.controller;

import java.io.IOException;
import java.util.Objects;

import org.fran.upload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class UploadFileController {

	private final FileService fileService;

	@Autowired
	public UploadFileController(FileService fileService) {
		this.fileService = Objects.requireNonNull(fileService);
	}

	@PostMapping(value = "/api/v1/files")
	@ResponseStatus(HttpStatus.OK)
	public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		System.out.println("Received file: " + file.getName());
		fileService.storeFile(file);
	}

	@PostMapping(value = "/api/v1/{id}/documents")
	public DeferredResult<ResponseEntity<?>> uploadDocuments(@PathVariable int id,
			@RequestParam("file") MultipartFile[] files) throws IOException {

		fileService.storeFile(files[id]);

		return null;

	}
}
