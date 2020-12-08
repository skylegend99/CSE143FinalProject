#UW Autumn 2020 CSE143 Final Project 
### Team member: 
- Yuran Feng
				
- Xiyi Wang
             
- Dicheng Wu.

##User Guide

###1. Program Introduction

Hello! We are Group 22.
Our program is called "If You Are The One", aimed at helping students find their best fit TA. 
We have 3 functions, all of which would have interaction with users in a web app:

(1)"Search": In this function, user can search for any TA's information, including the name, picture，
			 pronoun, email, quiz section, IPL time, and a personal introduction.
			 This funtion helps user familiar with the basic information of this TA.

(2)"Blind date": This function would help match the user up with his/her ideal TA.
				 Here users can select their expectations, such as their preferred section time, 
				 preferred teaching styles or preferred personalities of this TA.

(3)"View the intended Section": In this funtion, we will present the number/statistics of users who already 
								chose the same TA so far. Given that there are usually limited spots 
								in the registration of a section and each student's registration time is usually different, 
								it's better for a user to know how many other students want this TA too.
								Thus it would give the user a second chance to think about whether this
								TA/section is the most suitable.

In the three functions above, users can end the program anytime and directly display the results.
								

###2. How to run this program

To run this program on ed, you'll need to do the following steps:

(1) See our overall toggle tree by clicking the button "Toggle Tree View" in the top left.

(2) Find and click "main.java" in the left side.

(3) Click the button "Open Terminal" on the top, open a terminal and type the following:

	javac main.java
	java main

(4) There should be a remote web app turning up. If not, then click "Remote App" button on the top.

(5) The first page is asking which course (CSE 142/143) you are interested in. 
	Inputing different course will lead you to different search system.

(6) Choose one of the 3 functions:

In "Search", type in the name of any TA. If you misspell the name, the program will automatically do 
the auto-correct process and present the closest result; The TA's information, includingthe pronouns, 
name of the section, the IPL section time, the email, and the time of the quiz section, is displayed. 

In "Blind-date", each TA is represented as a lamp. It is on at the beginning and the users can
tap the buttons to choose their perferred types. Once they are done with their choices, they can tap
the "get result" button - one or more TAs that fits relatively most of the options is displayed and their 
corresponding lamp will be turned on.

In "View", users can type the name of the TA with autocorrect in order to see how many students would
like to choose this TA's quiz section. Since they cannot officially register for the section in this program,
this option helps the students to understand how popular the section is. Users can participate in the number
of people being displayed by "View" by pressing the button.  

(7) 












