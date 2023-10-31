# -*- coding: utf-8 -*-
"""
Created on Thu Oct 16 16:15:38 2023

@author: ujjwal
"""

import pandas as pd
import os

# a. Getting the data
path = "C:/Users/ujjwa/OneDrive - Centennial College/Documents/Semester_3/Artificial_Intelligence/Assignments/Logistic_Regression/"
file_name = "titanic.csv"

file_path = os.path.join(path, file_name)

titanic_ujjwal = pd.read_csv(file_path)
# print(titanic_ujjwal
# print(titanic_ujjwal.columns.values)

# b. Initial Exploration
# Displaying the data information
print(titanic_ujjwal.head(3))
print(titanic_ujjwal.shape)
print(titanic_ujjwal.info())

"""
Req - Written Response
Not useful columns:
    a. passengerId -> It has 891 unique ids. It's not useful for predicting anything.
    b. Name -> It is similar to passengerId, has most name as unique, not useful for any predictions.
    c. Ticket -> Tickets does also contains mostly unique values. It does not provide meaningful predictive power.
    d. Cabin -> It has lot of missing values. Which makes it complex to use for predictions.
"""

print(titanic_ujjwal['Sex'].unique())
print(titanic_ujjwal['Pclass'].unique())

# c. Data visualization
import matplotlib.pyplot as plt

table = pd.crosstab(titanic_ujjwal.Pclass,titanic_ujjwal.Survived)
table.div(table.sum(1).astype(float), axis=0).plot(kind='bar', stacked=True)
plt.title('(Ujjwal) Passenger Class vs Passenger Survival')
plt.xlabel('Passenger Class (1st, 2nd, and 3rd)')
plt.ylabel('Passenger Survival (1 = survived)')

table = pd.crosstab(titanic_ujjwal.Sex,titanic_ujjwal.Survived)
table.div(table.sum(1).astype(float), axis=0).plot(kind='bar', stacked=True)
plt.title('(Ujjwal) Passenger Gender vs Passenger Survival')
plt.xlabel('Passenger Gender (Male and Female)')
plt.ylabel('Passenger Survival (1 = survived)')

display_columns = ['Survived', 'Sex', 'Pclass', 'Fare', 'SibSp', 'Parch']
whole_data = titanic_ujjwal[display_columns]
pd.plotting.scatter_matrix(whole_data, alpha=0.2, figsize=(12, 12), diagonal='hist')
plt.show()

"""
Req - Written Response
Analyzation of these graphs
"""

to_drop_column = ['PassengerId', 'Name', 'Ticket', 'Cabin']
for i in to_drop_column:
    titanic_ujjwal.drop(columns=[i], inplace=True)
print(titanic_ujjwal)

categorical_values = ['Sex', 'Embarked']
for value in categorical_values:
    titanic_values = 'value' + '_' + value
    print(titanic_values)
    titanic_values = pd.get_dummies(titanic_ujjwal[value], prefix=value)
    titanic_ujjwal_1 = titanic_ujjwal.join(titanic_values)
    titanic_ujjwal = titanic_ujjwal_1
    
for i in categorical_values:
    titanic_ujjwal.drop(columns=[i], inplace=True)
    
print(titanic_ujjwal)


# Replacing all the null values wiht the mean of age

mean_age = titanic_ujjwal['Age'].mean()
titanic_ujjwal['Age'] = titanic_ujjwal['Age'].fillna(mean_age)
    
# Changing the column types into float
titanic_ujjwal = titanic_ujjwal.astype(float)

# Checking the output
titanic_ujjwal.info()

# Normalizer function
def normalize_dataframe(data_frame):
    df = (data_frame - data_frame.min()) / (data_frame.max() - data_frame.min())
    return df

# Final normalized dataframe
titanic_ujjwal_final = normalize_dataframe(titanic_ujjwal)

# Printing top 2 data
print(titanic_ujjwal_final.head(2))

# Using pandas hist ot generate the records
titanic_ujjwal_final.hist(figsize=(9, 10))
plt.show()

# Splitting the features into 70% and 30% for training and testing set
from sklearn.model_selection import train_test_split

titanic_ujjwal = titanic_ujjwal_final

x_ujjwal = titanic_ujjwal_final.drop(columns=['Survived'])
y_ujjwal = titanic_ujjwal_final['Survived']

seed = 84
x_train_ujjwal, x_test_ujjwal, y_train_ujjwal, y_test_ujjwal = train_test_split(x_ujjwal, y_ujjwal, test_size=0.3, random_state=seed)

from sklearn.feature_selection import RFE
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import cross_val_score
import numpy as np

ujjwal_model = LogisticRegression()
ujjwal_model.fit(x_train_ujjwal, y_train_ujjwal)

ujjwal_coef = pd.DataFrame(zip(x_train_ujjwal, np.transpose(ujjwal_model.coef_)))
print(ujjwal_coef)

"""
Cross validation
"""
# Initializing variables to store results
best_test_size = None
best_mean_accuracy = 0

# Ranges of test sizes from 10% to 50% in increments of 5%
test_sizes = np.arange(0.10, 0.50, 0.05)

# Iterating through different test sizes
for test_size in test_sizes:
    # Splitting the data into training and test sets based on the current test_size
    x_train, x_test, y_train, y_test = train_test_split(x_ujjwal, y_ujjwal, test_size=test_size, random_state=seed)
    
    # Creating and fitting the logistic regression model
    ujjwal_model = LogisticRegression()
    ujjwal_model.fit(x_train, y_train)
    
    # 10-fold cross-validation and collect accuracy scores
    scores = cross_val_score(ujjwal_model, x_train, y_train, cv=10, scoring='accuracy')
    
    # Calculating the minimum, mean, and maximum accuracy scores
    min_accuracy = np.min(scores)
    mean_accuracy = np.mean(scores)
    max_accuracy = np.max(scores)

    # Printing the results for the current test size
    print(f"Test Size: {test_size:.0%}")
    print(f"Minimum Accuracy: {min_accuracy:.4f}")
    print(f"Mean Accuracy: {mean_accuracy:.4f}")
    print(f"Maximum Accuracy: {max_accuracy:.4f}")
    print()

    # Checking if the current test size has a better mean accuracy
    if mean_accuracy > best_mean_accuracy:
        best_mean_accuracy = mean_accuracy
        best_test_size = test_size

# Recommended best split scenario
print(f"Recommended Best Test Size: {best_test_size:.0%}")

"""
Testing the model
"""

# Rebuilding the model using 30% and 70% split
x_train_ujjwal, x_test_ujjwal, y_train_ujjwal, y_test_ujjwal = train_test_split(x_ujjwal, y_ujjwal, test_size=0.3, random_state=seed)

# Defining a new variable to store the predicted probability
# predict_proba method provides the probability of each class
y_pred_ujjwal_probabilities = ujjwal_model.predict_proba(x_test_ujjwal)[:, 1]

# Defining another variable to store boolean value
y_pred_ujjwal_flag = y_pred_ujjwal_probabilities > 0.5

from sklearn.metrics import confusion_matrix, accuracy_score, classification_report

# Calculating accuracy
accuracy_ujjwal = accuracy_score(y_test_ujjwal, y_pred_ujjwal_flag)
print(accuracy_ujjwal)

# Calculating confusion matrix
confusion_matrix_ujjwal = confusion_matrix(y_test_ujjwal, y_pred_ujjwal_flag)
print(confusion_matrix_ujjwal)

# Calculating the classification report
classification_report_ujjwal = classification_report(y_test_ujjwal, y_pred_ujjwal_flag)
print(classification_report_ujjwal)

# Changing the threshold to 0.75
y_pred_ujjwal_flag_thres = y_pred_ujjwal_probabilities > 0.75

# Accuracy
accuracy_ujjwal_thres = accuracy_score(y_test_ujjwal, y_pred_ujjwal_flag_thres)
print(accuracy_ujjwal_thres)

# Confusion Matrix
confusion_matrix_ujjwal_thres = confusion_matrix(y_test_ujjwal, y_pred_ujjwal_flag_thres)
print(confusion_matrix_ujjwal_thres)

# Calculating the accuracy on training data
accuracy_train = accuracy_score(y_train_ujjwal, ujjwal_model.predict(x_train_ujjwal))
print(f"Accuracy on Training Data: {accuracy_train:.4f}")

# Calculating the accuracy on testing data
accuracy_test = accuracy_score(y_test_ujjwal, y_pred_ujjwal_flag)
print(f"Accuracy on Test Data: {accuracy_test:.4f}")

# Comparing the accuracies
if accuracy_test > accuracy_train:
    print("Accuracy on Test Data is higher than Training Data.")
else:
    print("Accuracy on Training Data is higher than Test Data.")
    
from sklearn.metrics import precision_score, recall_score

# Calculating precision score and recall score at threshold 0.5
# Accuracy score for both are already calculated above

precision_ujjwal = precision_score(y_test_ujjwal, y_pred_ujjwal_flag)
print(f"Precision at Threshold 0.5: {precision_ujjwal:.4f}")

recall_ujjwal = recall_score(y_test_ujjwal, y_pred_ujjwal_flag)
print(f"Recall at Threshold 0.5: {recall_ujjwal:.4f}")

# Calcualting precision score and recall score at threshold 0.75
precision_ujjwal_thres = precision_score(y_test_ujjwal, y_pred_ujjwal_flag_thres)
print(f"Precision at Threshold 0.5: {precision_ujjwal_thres:.4f}")

recall_ujjwal_thres = recall_score(y_test_ujjwal, y_pred_ujjwal_flag_thres)
print(f"Recall at Threshold 0.5: {recall_ujjwal_thres:.4f}")

# Compairing the Accuracy
if accuracy_ujjwal > accuracy_ujjwal_thres:
    print("Accuracy at Threshold 0.5 is higher than at Threshold 0.75.")
elif accuracy_ujjwal < accuracy_ujjwal_thres:
    print("Accuracy at Threshold 0.75 is higher than at Threshold 0.5.")
else:
    print("Accuracy is the same at both thresholds.")

# Compairing the precision
if precision_ujjwal > precision_ujjwal_thres:
    print("Precision at Threshold 0.5 is higher than at Threshold 0.75.")
elif precision_ujjwal < precision_ujjwal_thres:
    print("Precision at Threshold 0.75 is higher than at Threshold 0.5.")
else:
    print("Precision is the same at both thresholds.")

# Compairing the recall
if recall_ujjwal_thres > recall_ujjwal_thres:
    print("Recall at Threshold 0.5 is higher than at Threshold 0.75.")
elif recall_ujjwal_thres < recall_ujjwal_thres:
    print("Recall at Threshold 0.75 is higher than at Threshold 0.5.")
else:
    print("Recall is the same at both thresholds.")