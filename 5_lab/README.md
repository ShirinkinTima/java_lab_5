# **Лабораторная по Java №5. Ширинкин Тимофей ИТ-12-2024**  
## Структура  
<img width="588" height="1233" alt="изображение" src="https://github.com/user-attachments/assets/3c144816-b9ed-47db-9b51-4c1a455abaee" />

## Пакет cat
### Содержание  
Класс **Cat** реализует метод "meow"интерфейса meowable. 
<img width="784" height="155" alt="изображение" src="https://github.com/user-attachments/assets/58a096df-1bd0-4028-85a0-6551340d3205" />  

Класс **CountingCat** реализует выполнение метода "meow" для кошки, а также его подсчёт. Счётчик можно сбросить. 
<img width="751" height="392" alt="изображение" src="https://github.com/user-attachments/assets/27e28854-0a57-4d14-a6e7-a970408f35ad" />  

Класс **Meows** заставляет мяукнуть кота рандомное количество раз от 1 до 7, либо заданное количество раз. 
<img width="1029" height="884" alt="изображение" src="https://github.com/user-attachments/assets/546e0a52-e94e-4c6e-bdbd-5d41361c78a8" />  
### Тесты  
<img width="302" height="481" alt="изображение" src="https://github.com/user-attachments/assets/5b98dc49-2bd9-4239-9f91-0040ab4542b2" />  
## Пакет consonantletters  
### Содержание  
Класс **ConsonantLetters** реализует подсчёт согласных букв русского алфавита в тексте. Выводит те буквы, которые встречаются только в одном слове текста.  
### Тесты  
<img width="542" height="241" alt="изображение" src="https://github.com/user-attachments/assets/efdef63a-f308-4642-b1ed-069125e57c00" />  
<img width="619" height="130" alt="изображение" src="https://github.com/user-attachments/assets/071547c7-62a8-452d-a3c8-13661bde2ef0" />


## **Пакет fraction**  
### Содержание  
Класс **Fraction** содержит целочисленные поля числителя и знаменателя.  
Класс **CachedFraction** сохраняет результат деления "числитель/знаменатель" при первом вызове "getValue()", ускоряет работу.
### Тесты  
<img width="791" height="394" alt="изображение" src="https://github.com/user-attachments/assets/4bb75a5c-1326-45ac-be51-2dbae2af3dc4" />  

## Пакет geometry
### Содержание  
Класс **Point** содержит координаты одной точки.  
Класс **Line** содержит координаты начальной и конечной точек, образующих линию.  
Класс **Polyline** содержит множество точек, образующих кривую линию.  
### Тесты  
## **Пакет map**
### Содержание  
Класс **Participant** содержит ФИ участника, но оно не нужно я по приколу сделал, надеюсь вы это не читаете. 
<img width="533" height="86" alt="изображение" src="https://github.com/user-attachments/assets/80bf1f66-4832-44e0-ba3c-f3280be2f45a" />  

Класс **WinnersMap** читает список участников в формате <Фамилия> <Имя> <баллы_1этап> <баллы_2этап> <баллы_3этап>; создаёт список "Ключ - Значение", в котором __Ключ__ = сумма баллов, __Значение__ = список из людей, набравших это количество баллов. Сохраняет список в поле scoreboard.  
<img width="1133" height="74" alt="изображение" src="https://github.com/user-attachments/assets/cdd1af49-fdbb-48fb-a0c5-77dc7caf6dc1" />  
### Тесты  
<img width="519" height="269" alt="изображение" src="https://github.com/user-attachments/assets/3d18004d-5108-4bdb-beb6-6e97f8a60f03" />  
<img width="435" height="265" alt="изображение" src="https://github.com/user-attachments/assets/0b2d0fa8-2cb3-4e04-a4ad-cae0c1b33ce6" />  

## **Пакет peoplegrouper**  
### Содержание  
Класс **PeopleGrouper** - читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в верхнем регистре, убираем из перечня всех людей без номеров, а имена оставшихся группируются по их номеру.  
### Тесты  
<img width="318" height="381" alt="изображение" src="https://github.com/user-attachments/assets/b5b6e828-c7a6-49fc-a192-f5d364ba3707" />  
<img width="405" height="232" alt="изображение" src="https://github.com/user-attachments/assets/478a8dd6-a177-4541-b10f-aaae07f3d70b" />

## **Пакет queue**  
### Содержание  
Класс **SegmentEqual** принимает очередь "T" типа и интервал. Проверяет, состоит ли интервал очереди из одного и того же элемента. Возвращает true/false.  
### Тесты  
<img width="669" height="203" alt="изображение" src="https://github.com/user-attachments/assets/2a59dc73-1cc7-4aa2-b389-6063ef2dab82" />  

## **Пакет streampolyline**  
### Содержание  
Класс **StreamPolyline** убирает точки с одинаковыми X,Y. Сортирует по X. Отрицательные Y делает положительными. Собирает это все в ломаную (возвращает объект типа Polyline).  
<img width="1106" height="575" alt="изображение" src="https://github.com/user-attachments/assets/5c804440-5481-4f0a-b9d3-75957e5290d8" />
### Тесты  
<img width="802" height="167" alt="изображение" src="https://github.com/user-attachments/assets/8c12eece-bb3e-454e-b7ce-1a04f06f0fe6" />  

