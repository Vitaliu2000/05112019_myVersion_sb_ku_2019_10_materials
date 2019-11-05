package ru.itvitality.sbrf.cu.rj.atm;

import ru.itvitality.sbrf.cu.rj.atm.atm.ATM;
import ru.itvitality.sbrf.cu.rj.atm.atm.ATMService;
import ru.itvitality.sbrf.cu.rj.atm.atm.impl.ATMImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.nio.file.Files.*;

public class Starter {
    private ATM atm;
    private String FILE_NAME;
    List<Nominal> nominals = new ArrayList<>();

    public static void main( String args[] ) throws IOException {
        Starter starter = new Starter();
        starter.FILE_NAME = "java_reboot_L06/atm.ss";
        starter.startAtm();

        starter.startClientInteraction("java_reboot_L06/atm.ss");
    }

    private void startClientInteraction(String fileName) throws IOException, NoSuchFileException {
        //Проверка на наличие файла в сисеме. Если его нет, то создает его.
        File f = new File("java_reboot_L06/atm.ss");
        if(f.exists() && !f.isDirectory()) {
            System.out.println("Файл 'atm.ss' присутствует");
        } else {
            System.out.println("Файл 'atm.ss' отсутствует. Система создает его.");
            PrintWriter writer = new PrintWriter("java_reboot_L06/atm.ss", "UTF-8");
            writer.close();
        }

        Path path = Paths.get(fileName);
        //считываем содержимое файла в массив байт
        byte[] bytes = readAllBytes(path);
        //считываем содержимое файла в список строк
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

        System.out.println(allLines);

        for (int i = 0; i < allLines.size(); i++) {
            if (allLines.get(i).startsWith(Nominal.ONE_HUNDRED.getNominal().toString() + ":") && !allLines.get(i).endsWith(":0")){
                String value = allLines.get(i);
                String valueCount = value.substring(value.lastIndexOf(':') + 1);
                //Кол-во купюр
                int valueCountNum = Integer.parseInt(valueCount);
                Integer valueNom = Nominal.ONE_HUNDRED.getNominal();
                Nominal nominal = Nominal.getNominalFromInt( valueNom );
                for (int j = 0; j < valueCountNum; j++) {
                    nominals.add( nominal );
                }
                break;
            }
        }

        for (int i = 0; i < allLines.size(); i++) {
            if (allLines.get(i).startsWith(Nominal.TWO_HUNDREDS.getNominal().toString() + ":") && !allLines.get(i).endsWith(":0")){
                String valueCount = allLines.get(i).substring(allLines.get(i).lastIndexOf(':') + 1);
                Nominal nominal = Nominal.getNominalFromInt( Nominal.TWO_HUNDREDS.getNominal() );
                for (int j = 0; j < Integer.parseInt(valueCount); j++) {
                    nominals.add( nominal );
                }
                break;
            }
        }

        for (int i = 0; i < allLines.size(); i++) {
            if (allLines.get(i).startsWith(Nominal.FIVE_HUNDRED.getNominal().toString() + ":") && !allLines.get(i).endsWith(":0")){
                String valueCount = allLines.get(i).substring(allLines.get(i).lastIndexOf(':') + 1);
                Nominal nominal = Nominal.getNominalFromInt( Nominal.FIVE_HUNDRED.getNominal() );
                for (int j = 0; j < Integer.parseInt(valueCount); j++) {
                    nominals.add( nominal );
                }
                break;
            }
        }

        for (int i = 0; i < allLines.size(); i++) {
                    if (allLines.get(i).startsWith(Nominal.ONE_THOUSAND.getNominal().toString() + ":") && !allLines.get(i).endsWith(":0")){
                        String valueCount = allLines.get(i).substring(allLines.get(i).lastIndexOf(':') + 1);
                        Nominal nominal = Nominal.getNominalFromInt( Nominal.ONE_THOUSAND.getNominal() );
                        for (int j = 0; j < Integer.parseInt(valueCount); j++) {
                            nominals.add( nominal );
                        }
                        break;
                    }
                }

        for (int i = 0; i < allLines.size(); i++) {
                    if (allLines.get(i).startsWith(Nominal.TWO_THOUSANDS.getNominal().toString() + ":") && !allLines.get(i).endsWith(":0")){
                        String valueCount = allLines.get(i).substring(allLines.get(i).lastIndexOf(':') + 1);
                        Nominal nominal = Nominal.getNominalFromInt( Nominal.TWO_THOUSANDS.getNominal() );
                        for (int j = 0; j < Integer.parseInt(valueCount); j++) {
                            nominals.add( nominal );
                        }
                        break;
                    }
                }

        for (int i = 0; i < allLines.size(); i++) {
                    if (allLines.get(i).startsWith(Nominal.FIVE_THOUSANDS.getNominal().toString() + ":") && !allLines.get(i).endsWith(":0")){
                        String valueCount = allLines.get(i).substring(allLines.get(i).lastIndexOf(':') + 1);
                        Nominal nominal = Nominal.getNominalFromInt( Nominal.FIVE_THOUSANDS.getNominal() );
                        for (int j = 0; j < Integer.parseInt(valueCount); j++) {
                            nominals.add( nominal );
                        }
                        break;
                    }
                }

        System.out.println( "Hello, my dear friend. What's your name?" );
        Scanner scanner = new Scanner( System.in );
        String name = scanner.nextLine();
        System.out.println( "Hello " + name + "! What's your command? (add, get, exit)" );
        String operation = scanner.nextLine();

        while ( ! operation.equalsIgnoreCase( "exit" ) ) {
            switch ( operation.toLowerCase() ) {
                case "add":
                    System.out.println( "What nominal?" );
                    Integer value = scanner.nextInt();
                    scanner.nextLine();
                    Nominal nominal = Nominal.getNominalFromInt( value );
                    if ( nominal != null ) {
                        nominals.add( nominal );
                        //atm.putCash( nominals );
                        System.out.println( "Success" );
                    } else {
                        System.out.println( "Was is das?" );
                    }
                    break;
                case "get":
                    System.out.println("Какой номинал взять из банкомата?");
                    Integer GetValue = scanner.nextInt();
                    scanner.nextLine();
                    Nominal nominalGetValue = Nominal.getNominalFromInt( GetValue );
                    if ( nominalGetValue != null ) {
                        for (int i = 0; i < nominals.size(); i++) {
                            //Если в списке есть введенный элемент
                            if (nominals.contains(nominalGetValue)){
                                //Добовляем его в отдельный список, а
                                ArrayList list= new ArrayList();
                                list.add(nominalGetValue);
                                //из банкомата удаляем эту купюру
                                nominals.remove(nominalGetValue);
                                break;
                            }
                        }
                        System.out.println("В банкомате осталось: " + nominals);
                    } else {
                        System.out.println( "В банкомате нет такой купюры" );
                    }
                    break;
                /*case "q":
                    System.out.println("Ячейку какого номинала выдернуть из банкомата?");
                    Integer GetCell = scanner.nextInt();
                    scanner.nextLine();
                    Nominal nominalCellValue = Nominal.getNominalFromInt( GetCell );
                    if ( nominalCellValue != null ) {

                        File inputFile = new File("atm.ss");
                        File tempFile = new File("myTempFile.txt");

                        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        //String lineToRemove = "bbb";
                        String lineToRemove2 = Nominal.ONE_HUNDRED.getNominal().toString();
                        String lineToRemove3 = lineToRemove2 + ":";
                        String qa = String.valueOf(GetCell);
                        String qa2 = qa + ":";
                        String currentLine;
                        System.out.println("lineToRemove2 = " + lineToRemove2);
                        System.out.println("lineToRemove3 = " + lineToRemove3);
                        System.out.println("qa = " + qa);
                        System.out.println("qa2 = " + qa2);
                        while((currentLine = reader.readLine()) != null) {
                            String trimmedLine = currentLine.trim();
                            if(trimmedLine.equals(qa2)) continue;
                            writer.write(currentLine + System.getProperty("line.separator"));
                        }
                        writer.close();
                        reader.close();
                        boolean successful = tempFile.renameTo(inputFile);

                    } else {
                        System.out.println( "В банкомате нет такой купюры" );
                    }
                    break;*/
                default:
                    System.out.println( "Incorrect command" );
            }
            System.out.println( " What's your next command? (add, get, exit)" );
            operation = scanner.nextLine();
        }
        atm.putCash( nominals );
        ( (ATMService) atm ).saveToFile( FILE_NAME );
    }

    private void startAtm() {
        atm = new ATMImpl();
    }
}