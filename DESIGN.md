# Design document
The design document discusses the project’s technical implementation details and reasoning behind design decisions.

## Design Strategy

### Task: Find their best fit TA.

We start of the program by implementing data structure and algorithm first inside the Function class. 
The program has three functions: 

1. Search TA
	- Read and Store information of each TA. 
	>  public Map<String, Information> constructInfo(int course)
	- Search TA from the map
	>  public Information search(String name)
	- Auto correct spelling error. Explain: distance.apply() will return an int. The smallest of that number returned, the misspelling word is more close to the correct word.
 	>  int temp = distance.apply(correct, misspelling);
 
2. Blind Date
    - Calculate the feature score for each TA.
    > public void rating(Set<String> features) 
    - Find the TA who has the largest score.
    > public String largest() 

3. View the intended Section
	- Search for avaliable space for a TA's section.


### Description of each class

1. Information class: Store each TA's Information in its fields
2. Evaluation class: Store each TA's evaluation in its fields
3. Function class: read the input file and implement data structure to store files into Evaluation class or Information class. Each Node in the binary tree contains one of the TA's evaluation
4. graphic class: main panel for choose cse142 or cse143
![graphic](/src/datasets/main.png "main")
5. optionPanel class: made connection to the other three class
	*  searchTA class: Search your TA.
	*  Evaluator: Blind Date with your TA.
	*  viewTA: View the intended Section.

 
## Ways to implement tasks

* 

The design document discusses the project’s technical implementation details and reasoning behind design decisions.

## Our Choice of GUI 

We have studied console to interact with users, but we can show limited contents through that platform. Considering that there are several 
functions in this program and we would provide TA's pictures, we decided to utilize GUI. This could help us interact with users through 
graphical icons and thus present a better visualized results. The Jbuttons and JtextFields provided by GUI give us an oppourtunity to improve 
the user interface because the users only need click the Jbuttons(instead of type) for most of the features. The autocorrect feature, as 
described below, is another way to improve the user experience. 


## The Datasets 

We collects all 142 & 143 TAs' basic information listed in "142.csv" and "143.csv", and all their photos stored in "142" and "143" folder.
However, we only received 0 CSE142 TA and 8 CSE143 TA's evaluation listed in "evaluation.csv". 
We expected to collect all of 142 & 143 TAs' evaluations via google form, but only a few TAs from CSE143 and fewer CSE142 TAs respond. 
Randomizing the TAs' evaluations might be disrespectful to them if some results are opposing to their actual characteristic. 
Since there is no specific requirement for the quantity of data and we'd like to demonstrate the result that fits the reality, 
we only use 8 data from CSE143 TAs in "Blind-date" function. 


## The Autocorrect Function 

We added the autocorrect process to every search-related method. When the user misspelled the name, the program would display dialogs like
"We cannot find the TA you are looking for, but here is the closest result according to your input" and automatically generate
the most relevent TA. To accomplish this goal, we use the Levenshtein distance algorithm to compare the similarity between two strings. 
We woule present the closest strings/TA's name. 


## Our Ways of Illustration 

![0](/src/datasets/bulb.jpg "bulb")
![1](/src/datasets/extinct.jpg "extinct")

In the "Blind-date" function, our idea comes from one of the most popular dating in China, called "If you are the one". In the dating show, there are 
24 female guests and 1 male guest in each round. Lamp represents as the memory point of the show. Each female guest has a lamp in front 
of them and it is on at the very beginning. While getting to deeper about the male guest, they can choose to turn off the lamp that means 
they show no more interest to the guy. We are surprised by the outstanding visual effect it produced when watching, thus this TV show is where the 
lamp concept comes from. But we made it differently, in order to conduct a more efficient selection, every lamp is off and the lamp of the best-fit TA 
is turned on as the result.

*layout in view

The registered seats / maximum avaliable seats format is similar to the format in myUW. We use the similar format because the layout is satisfied. 
