# Design document

The design document discusses the project's technical implementation details and the reasoning behind design decisions.

## Design Strategy

### Task: Find their best fit TA.

We start the project by implementing data structure and algorithm first inside the Function class. 
The program has three functions: 

1. Search TA
    - Read and Store information of each TA. 
    >  public Map<String, Information> constructInfo(int course)
    - Search TA from the map
    >  public Information search(String name)
    - Autocorrect spelling error. Explain: distance.apply() will return an int. The smallest of that number returned, the misspelling word is more close to the correct word.
     >  int temp = distance.apply(correct, misspelling);
 
2. Blind Date
    - Calculate the feature score for each TA.
    > public void rating(Set<String> features) 
    - Find the TA who has the largest score.
    > public String largest() 

3. View the intended Section
    - Search for available space for a TA's Section.
    > Use scanner to implement in the viewTA class
    

### Description of each class

1. Information class: Store each TA's Information in its fields
2. Evaluation class: Store each TA's evaluation in its fields
3. Function class: read the input file and implement data structure to store files into Evaluation class or Information class. Each Node in the binary tree contains one of the TA's evaluation
4. graphic class: main panel to choose CSE142 or CSE143
5. optionPanel class: made a connection to the other three class
    *  searchTA class: Search your TA.
    *  Evaluator class: Blind Date with your TA.
    *  viewTA class: View the intended Section.

## Reasoning behind design decisions
### Our Choice of GUI

We have studied how to interact with users in the console, but we can show limited content through that platform. Considering that there are several 
functions in this program, and we would provide TA's pictures, we decided to utilize GUI. This could help us interact with users through 
graphical icons and thus, present better-visualized results. The Jbuttons and JtextFields provided by GUI allow us to improve 
the user interface because the users only need to click the Jbuttons(instead of type) for most of the features. The autocorrect feature, as 
described below, is another way to improve the user experience. 

### The Datasets

We collect all 142 & 143 TAs' necessary information listed in "142.csv" and "143.csv", and all their photos are stored in the "142" and "143" folder.
However, due to the limited responses from TAs, we only have 0 CSE142 TA and 8 CSE143 TA's evaluation stored in "evaluation.csv." 
Since there is no specific requirement for the quantity of data, and we'd like to demonstrate the most authentic results, 
we only use 8 data from CSE143 TAs in the "Blind-date" function. To simulate the process of registration, 
we randomize the available seats listed in "142seats.csv" and "143seats.csv".


### The Autocorrect Function

We add the autocorrect process to every search-related method. When the user misspells the name, the program will display dialogs like
"We cannot find the exact TA you are looking for, but here is the closest result" and automatically generate
the most relevant TA. To accomplish this goal, we use the Levenshtein distance algorithm to compare the similarity between two strings. 
We would present the closest strings/TA's name. 


### Our Ways of Illustration

![0](/src/datasets/bulb.jpg "bulb")
![1](/src/datasets/extinct.jpg "extinct")

* Bulb in "Blind-date"

In the "Blind-date" function, our idea comes from one of the most popular dating TV shows in China, called "If you are the one". 
In that dating show, lamp is used to show the degree of a person's interest to the other. As they get to know each other better, 
the lamp might be keep on or turned off. We are surprised by this outstanding visual effect it produced when watching, thus this TV show is where the 
lamp idea comes from. But we made it differently, in order to conduct a more efficient selection, every lamp bulb is off and the bulb of the best-fit TA 
is turned on as the result.

Also, the best-fit TA here means the one who has the highest score. When he/she fits a preferred type given by user, that TA's score would add 1.

* Layout in "View the intended Section"

The registered seats / maximum avaliable seats format is similar to the format in myUW. We use the similar format because the layout is satisfied.
