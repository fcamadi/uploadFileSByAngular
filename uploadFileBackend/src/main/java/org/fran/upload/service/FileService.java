package org.fran.upload.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileService {

	private static final String FILE_DIRECTORY = "/home/francd/uploadedFiles";

	private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();

	public void storeFile(MultipartFile file) throws IOException {

		Path filePath = Paths.get(FILE_DIRECTORY + FILE_SEPARATOR + file.getOriginalFilename());

		System.out.println("Received file: " + filePath.getFileName());

		// copia de seguridad (una prueba)
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		// mandarlo a anonimizar

	}

}
