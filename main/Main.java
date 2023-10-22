import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

   
    private static final String FILENAME = "toys.txt";



    public static void main(String[] args) {

        try {

            ToyShop shop = new ToyShop();

            File toyFile = new File(FILENAME);



            if (!toyFile.exists()) {

                toyFile.createNewFile();

                shop.add(new Toy(1, "Барби", 5, 10));

                shop.add(new Toy(2, "Машинка", 15, 10));

                shop.add(new Toy(3, "Тедди", 3, 10));

                shop.saveToFile(FILENAME);

            } else {

                shop.loadFromFile(FILENAME);

            }

            shop.setWeight(3, 30); // изменить вес Тедди на 30%

            ArrayList<String> toyList = shop.getToyList(); // получить список игрушек в магазине

            for (String toy : toyList) {

                System.out.println(toy);

            }



            ArrayList<Toy> winners = shop.playGame(3); // разыграть 3 игрушки

            System.out.println("Выиграли следующие игрушки:");

            for (Toy t : winners) {

                System.out.println(t.getName());

            }



            shop.saveToFile(FILENAME); // сохранить данные об игрушках в файл

        } catch (IOException e) {

            System.out.println("Ошибка при работе с файлами: " + e.getMessage());

        }

    }

}