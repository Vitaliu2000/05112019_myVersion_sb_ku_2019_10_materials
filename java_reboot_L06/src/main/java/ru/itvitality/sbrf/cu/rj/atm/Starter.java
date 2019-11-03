package ru.itvitality.sbrf.cu.rj.atm;

import ru.itvitality.sbrf.cu.rj.atm.atm.ATM;
import ru.itvitality.sbrf.cu.rj.atm.atm.ATMService;
import ru.itvitality.sbrf.cu.rj.atm.atm.impl.ATMImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {
    private ATM atm;
    private String FILE_NAME;
    List<Nominal> nominals = new ArrayList<>();

    public static void main( String args[] ) throws IOException {
        Starter starter = new Starter();
        starter.FILE_NAME = args[ 0 ];
        starter.startAtm();

        starter.startClientInteraction();
    }

    private void startClientInteraction() throws IOException {
        System.out.println( "Hello, my dear friend. What's your name?" );
        Scanner scanner = new Scanner( System.in );
        String name = scanner.nextLine();
        System.out.println( "Hello " + name + "! What's your command? (add, get, exit)" );
        String operation = scanner.nextLine();

        while ( ! operation.equalsIgnoreCase( "e" ) ) {
            switch ( operation.toLowerCase() ) {
                case "add":
                    System.out.println( "What nominal?" );
                    Integer value = scanner.nextInt();
                    scanner.nextLine();
                    Nominal nominal = Nominal.getNominalFromInt( value );
                    if ( nominal != null ) {
                        nominals.add( nominal );
                        System.out.println( "Success" );
                        //Для отладки ниже
                        /*for (int i = 0; i < nominals.size(); i++) {
                            for (int j = 0; j < nominals.size(); j++) {
                                System.out.println("В банкомате " + nominals.get(j).getNominal()+ " ");
                            }
                        }*/
                        //Для отладки выше
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
                default:
                    System.out.println( "Incorrect command" );
            }

            System.out.println( " What's your next command? (add, get, exit)" );
            operation = scanner.nextLine();
        }
        ( (ATMService) atm ).saveToFile( FILE_NAME );

    }

    private void startAtm() {
        atm = new ATMImpl();
    }
}