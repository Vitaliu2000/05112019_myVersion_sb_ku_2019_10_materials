ДЗ:
* Доделать команды для клиента банкомата в консоли
* Доделать сохранение состояния банкомата и его восстановление из файла
* Сделать возможность добавление и изъятия ячеек из банкомата. !!! Может оказаться более одной ячейки одинакового номинала
* Запуск банкомата как  jar и работа с ним как с отдельной программой

* ** Сделать добавление купюр массивом (ввод через пробел)
* ** Сделать тесты на Starter и взаимодействие с файлом. Тут нам моки в помощь https://site.mockito.org/

ДЗ:
1. Доделать команды для клиента банкомата в консоли 
• Это означает, что нужно сделать команду «get» - её суть такая же как и «add» - 
она должна забирать купюры из банкомата. И выводить или ошибку или список купюр в строку через пробел


2. Доделать сохранение состояния банкомата и его восстановление из файла 
• Детализируйте, пожалуйста. Мне не понятно что конкретно нужно сделать.
    2. Сейчас мы сохраняем состояние банкомата в файл. Надо при старте банкомата прочитать и восстановить состояние.  При этом не забыть, что файла может и не быть

3. Сделать возможность добавление и изъятия ячеек из банкомата. !!! Может оказаться более одной ячейки одинакового номинала 
• Я правильно понимаю, что должен быть набор ячеек, изъяв одну из них(с деньгами) в целом банкомате становится меньше денег? 
    3. Да, изменение состава ячеек влияет на общий баланс банкомата 

4. Запуск банкомата как jar и работа с ним как с отдельной программой 
• Т.е. настроить проект так, что бы можно было его запустить с командной строки, как в примере https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html 
    4. Да, у нас в итоге должен быть jar который можно запустить чем-то вроде java -jar atm.jar atm.ss

5** Сделать добавление купюр массивом (ввод через пробел) 
• Т.е. через консоль вводить номинал купюр после появления вопроса от IDEA «What nominal?» 
Пример:
add
What nominal? 
100 5000 200 
exit 
        5. Почти. После переноса каретки мы считаем список завершенным, его читаем и добавляем купюры в банкомат

6** Сделать тесты на Starter и взаимодействие с файлом. Тут нам моки в помощь https://site.mockito.org/
Не могли бы пример тестов показать как это по вашему мнению должно выглядеть?
    6. Попробуйте как получится. Последние 2 задачи со звездочкой. По принципу - если сможете. Если нет - не страшно. По мокито интересно что получится, на занятии разберем что вышло

В работе разработчика очень важный навык - осваивать инструмент новый самому.