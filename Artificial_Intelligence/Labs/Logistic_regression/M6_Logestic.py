# -*- coding: utf-8 -*-
"""
Created on Fri Aug  7 13:47:50 2020

@author: mhabayeb
"""
"""
Data Explortion
1-	Load the 'Bank.csv' file into a dataframe name the dataframe data_firstname_b where first name is your first name carry out the following activities:
a.	Display the column names
b.	Display the shape of the data frame i.e number of rows and number of columns
c.	Display the main statistics of the data
d.	Display the types of columns
e.	Display the first five records
"""
import pandas as pd
# set pandas options
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 100)
import os
path = "H:/Semester_3/Artificial_Intelligence/Labs/Logistic_regression/"
filename = 'Bank.csv'
fullpath = os.path.join(path,filename)
data_mayy_b = pd.read_csv(fullpath,sep=';')
print(data_mayy_b.columns.values)
print(data_mayy_b.shape)
print(data_mayy_b.describe())
print(data_mayy_b.dtypes) 
print(data_mayy_b.head(1))
print(data_mayy_b.age.describe())
"""
2-	Explore, Check & Process the data, we need to carry out several processing steps (clean up steps) before building the model as follows:
a.	1-change the y column from object to integer, this is the class or label column
b.	Reduce the categories of the education column
c.	Check the values of who purchased the deposit account
d.	Check the average of all the numeric columns
e.	Check the mean of all numeric columns grouped by education
f.	Plot a histogram showing purchase by education category
g.	Draw a stacked bar chart of the marital status and the purchase of term deposit to see whether this can be a good predictor of the outcome
h.	Plot the bar chart for the Frequency of Purchase against each day of the week to see whether this can be a good predictor of the outcome.
i.	Repeat step h for the month
j.	Plot a histogram of the age distribution
"""
print(data_mayy_b['education'].unique())
import numpy as np
data_mayy_b['education']=np.where(data_mayy_b['education'] =='basic.9y', 'Basic', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='basic.6y', 'Basic', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='basic.4y', 'Basic', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='university.degree', 'University Degree', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='professional.course', 'Professional Course', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='high.school', 'High School', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='illiterate', 'Illiterate', data_mayy_b['education'])
data_mayy_b['education']=np.where(data_mayy_b['education'] =='unknown', 'Unknown', data_mayy_b['education'])
#Check the values of who purchased the deposit account
print(data_mayy_b['y'].value_counts())
##Check the average of all the numeric columns
pd.set_option('display.max_columns',100)
print(data_mayy_b.groupby('y').mean())
#Check the mean of all numeric columns grouped by education
print(data_mayy_b.groupby('education').mean())
"""
Plotting
"""
#Plot a histogram showing purchase by education category
import matplotlib.pyplot as plt
help(pd.crosstab)
pd.crosstab(data_mayy_b.education,data_mayy_b.y)
#Create a histogram
pd.crosstab(data_mayy_b.education,data_mayy_b.y).plot(kind='bar')
plt.title('Purchase Frequency for Education Level')
plt.xlabel('Education')
plt.ylabel('Frequency of Purchase')
#
#draw a stacked bar chart of the marital status and the purchase of term deposit to see whether this can be a good predictor of the outcome
table=pd.crosstab(data_mayy_b.marital,data_mayy_b.y)
table.div(table.sum(1).astype(float), axis=0).plot(kind='bar', stacked=True)
plt.title('Stacked Bar Chart of Marital Status vs Purchase')
plt.xlabel('Marital Status')
plt.ylabel('Proportion of Customers')

##plot the bar chart for the Frequency of Purchase against each day of the week to see whether this can be a good predictor of the outcome
pd.crosstab(data_mayy_b.day_of_week,data_mayy_b.y).plot(kind='bar')
plt.title('Purchase Frequency for Day of Week')
plt.xlabel('Day of Week')
plt.ylabel('Frequency of Purchase')
###
print(data_mayy_b['day_of_week'].unique())
###
#Repeat for the month
pd.crosstab(data_mayy_b.month,data_mayy_b.y).plot(kind='bar')
plt.title('Purchase Frequency for Day of Week')
plt.xlabel('Month')
plt.ylabel('Frequency of Purchase')
###
#Plot a histogram of the age distribution
data_mayy_b.age.hist()
plt.title('Histogram of Age')
plt.xlabel('Age')
plt.ylabel('Frequency')
############################################
"""
Data pre-processing
4-	Deal with the categorical variables, as follows:
a.	Create the dummy variables , use a loop 
b.	Remove the original columns
c.	Prepare the data for the model build as X (inputs, predictor) and Y(output, predicted)
"""
#Deal with the categorical variables, use a for loop
#1- Create the dummy variables 
help(pd.get_dummies)
cat_vars=['job','marital','education','default','housing','loan','contact','month','day_of_week','poutcome']
for var in cat_vars:
    cat_list='var'+'_'+var
    print(cat_list)
    cat_list = pd.get_dummies(data_mayy_b[var], prefix=var)
    data_mayy_b1=data_mayy_b.join(cat_list)
    data_mayy_b=data_mayy_b1
data_mayy_b.head(5)
 #######
#  2- Removee the original columns
cat_vars=['job','marital','education','default','housing','loan','contact','month','day_of_week','poutcome']
data_mayy_b_vars=data_mayy_b.columns.values.tolist()
to_keep=[i for i in data_mayy_b_vars if i not in cat_vars]
#
data_mayy_b_final=data_mayy_b[to_keep]
data_mayy_b_final.columns.values
####  
# 3- Prepare the data for the model build as X (inputs, predictor) and Y(output, predicted)
data_mayy_b_final_vars=data_mayy_b_final.columns.values.tolist()
Y=['y']
X=[i for i in data_mayy_b_final_vars if i not in Y ]
type(Y)
type(X)
#5-	Carryout feature selection and update the data, as follows:
#a.	Carry out feature selection using the REF module from sklearn.model_selection to select only 12 feature
#b.	Update X and Y to reflect only 12 features

# We have many features so let us carryout feature selection
#from sklearn import datasets
from sklearn.feature_selection import RFE
from sklearn.linear_model import LogisticRegression
model = LogisticRegression()
rfe = RFE(model, n_features_to_select=12)
rfe = rfe.fit(data_mayy_b_final[X],data_mayy_b_final[Y])
print(rfe.support_)
print(rfe.ranking_)
#2- Update X and Y with selected features
cols=['previous', 'euribor3m', 'job_entrepreneur', 'job_self-employed', 'poutcome_success', 'poutcome_failure', 'month_oct', 'month_may',
    'month_mar', 'month_jun', 'month_jul', 'month_dec'] 
X=data_mayy_b_final[cols]
Y=data_mayy_b_final['y']
type(Y)
type(X)
"""
5-	Build the logistic regression model as follows:
a.	Split the data into 70%training and 30% for testing
b.	Build the model using “sklearn  linear_model.LogisticRegression” 
c.	Fit the training data
d.	Validate the parameters and check model accuracy

"""
#1- split the data into 70%training and 30% for testing, note  added the solver to avoid warnings
from sklearn.model_selection import train_test_split
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.3, random_state=0)

# 2-Let us build the model and validate the parameters
from sklearn import linear_model
from sklearn import metrics
clf1 = linear_model.LogisticRegression(solver='lbfgs')
clf1.fit(X_train, Y_train)

#3- Run the test data against the new model
probs = clf1.predict_proba(X_test)
print(probs)
type(probs)
predicted = clf1.predict(X_test)
print (predicted)
#4-Check model accuracy
print (metrics.accuracy_score(Y_test, predicted))

###
#7-	To avoid sampling bias run cross validation for 10 times, as follows:
#a.	Use the cross_val_score module from sklearn.model_selection and set the parameters
#b.	Save the results of each run in scores
#c.	Produce the mean

from sklearn.model_selection import cross_val_score
scores = cross_val_score(linear_model.LogisticRegression(solver='lbfgs'), X_train, Y_train, scoring='accuracy', cv=10)
print (scores)
print (scores.mean())

#####
#	Use the confusion_matrix option from the sklearn.metrics module to generate the matrix
# probs is an array we extract the first column
type(probs)
prob=probs[:,1]
prob_df=pd.DataFrame(prob)
prob_df['predict']=np.where(prob_df[0]>=0.05,1,0)
import numpy as np
Y_test=(Y_test=='yes').astype(int)
Y_A =Y_test.values
Y_P = np.array(prob_df['predict'])
type(Y_A)
type(Y_P)
from sklearn.metrics import confusion_matrix
confusion_matrix = confusion_matrix(Y_A, Y_P)
print (confusion_matrix)


	









