package com.sda.catalin.bookmanagement;

import com.sda.catalin.bookmanagement.controller.AuthorController;
import com.sda.catalin.bookmanagement.menu.UserOption;
import com.sda.catalin.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.catalin.bookmanagement.service.AuthorServiceImpl;
import com.sda.catalin.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();

        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));

        Scanner scanner = new Scanner(System.in);

        UserOption userOption;
        do {
            UserOption.printAllOption();
            System.out.println("Please select an option!");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case SHOW_ALL_AUTHORS:
                    authorController.showAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option unknown!");
                    break;
                default:
                    System.out.println("User option " + userOption + " is not implemented!");
                    break;
            }

        } while (userOption != UserOption.EXIT);
        SessionManager.shutDown();

    }

}