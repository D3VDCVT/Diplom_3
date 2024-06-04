# Diplom_3

## Технологии
* Java 11
* JUnit 4.13.2
* Rest-Assured 5.3.0
* Selenium 4.18.1
* Allure 2.15.0

## запуск в Chrome
```
mvn test
```
## запуск с Yandex
Необходимо указать свою версию драйвера и указать путь до браузера Яндекс
```
mvn -Dbrowser=yandex -Ddriver.version=122.0.6261.128 -Dwebdriver.yandex.bin=C:\\Users\\safeg\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe test
```
## Просмотр Allure-отчета
```
allure serve target/surefire-reports/
```