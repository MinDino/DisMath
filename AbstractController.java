package com.arcadial.restaurant.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AbstractController<T> {

	protected T loadReadIOFile(String directory) {

		T obj = null;

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(directory))) {
			
//			FileInputStream fileInputStream = new FileInputStream(directory);
//			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			obj = (T) objectInputStream.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("File failed to close successfully");
		}

		return obj;
	}

	protected void writeSaveIOFile(String directory, T obj) {

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(directory))) {

//			FileOutputStream fileOutputStream = new FileOutputStream(directory);
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("File failed to close successfully");
		}
	}
}
