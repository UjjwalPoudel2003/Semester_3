# -*- coding: utf-8 -*-
"""
Created on Thu Oct 10 22:41:19 2023

@author: ujjwal
"""

import pandas as pd
import numpy as np
import os
import matplotlib.pyplot as plt

# Using the path and accessing the data
path = "C:/"
file_name = "ecomexp.csv"
fullpath = os.path.join(path, file_name)

# Reading the csv file
ecom_exp_ujjwal = pd.read_csv(fullpath)
# print(ecom_exp_ujjwal)

# Displaying first three records
first_three_records = ecom_exp_ujjwal.head(3)
print("First 3 data sets are: ")
print(first_three_records)

# Shape of data frame
shape = ecom_exp_ujjwal.shape
print("\nShape of data frame:")
print(shape)

# Displaying the column names
column_names = ecom_exp_ujjwal.columns
print("\nColumn Names: ")
print(column_names)

# Displaying the types of columns
column_types = ecom_exp_ujjwal.dtypes
print("\nColumn Types: ")
print(column_types)

# Creating a list to store the name of column title
column_titles = []

# Displaying the missing values
missing_values = ecom_exp_ujjwal.isna().sum()
print("\nMissing Values per Column:")
for column, count in missing_values.items():
    if count > 0:
        column_titles.append(column)
        print(f"{column}: {count}")
    else:
        print(f"{column}: 0 (No missing values)")
        
# print(column_titles)

# Displaying the column names
# column_names = ecom_exp_ujjwal.columns
# print("\nColumn Names: ")
# print(column_names)


# # Creating the list of categorical columns
# categorical_columns = ['Transaction ID', 'Age ', ' Items ', 'Monthly Income', 'Transaction Time', 'Record', 'Gender', 'City Tier', 'Total Spend']

# getting the dummies and storing in variable
dummies1 = pd.get_dummies(ecom_exp_ujjwal.Gender)

dummies2 = pd.get_dummies(ecom_exp_ujjwal['Gender'], prefix='gen')

combined_dummies = pd.concat([dummies1, pd.get_dummies(ecom_exp_ujjwal.CityTier)], axis=1)

# Combining all the data frames
merged_dummy = pd.concat([ecom_exp_ujjwal, combined_dummies], axis=1)
merged_dummies = pd.concat([ecom_exp_ujjwal, combined_dummies], axis=1)

# Dropping the original columns
merged_dummies.drop(['Gender', 'CityTier'], axis=1, inplace = True)
# print(merged_dummies.columns.values)

# Dropping the transaction id column
merged_dummies.drop(['TransactionID'], axis = 1, inplace = True)

# Function to normalize the data frame
# def normalize_dataframe(data_frame):
#     # Applying the normalization formula to each column
#     for column in data_frame.columns:
#         if data_frame[column].dtype in [int, float]:
#             x_min = data_frame[column].min()
#             x_max = data_frame[column].max()
#             data_frame[column] = (data_frame[column] - x_min) / (x_max - x_min)
#     return data_frame

def normalize_dataframe(data_frame):
    df = (data_frame - data_frame.min()) / (data_frame.max() - data_frame.min())
    return df

# Normalizing the dataframe
normalize_dataframe(merged_dummies)

# Top 2 data
print(merged_dummies.head(2))

# Displaying the data in histogram
# Setting the figure size
plt.figure(figsize=(9, 10))

# Generating the histogram
ecom_exp_ujjwal.hist(bins=20, color='green')
plt.show()

data_frame = pd.DataFrame(np.random.randn(1000, 4), columns=['Age', 'MonthlyIncome', 'Transaction Time', 'TotalSpend'])
pd.plotting.scatter_matrix(data_frame, alpha = 0.4, figsize=(13, 15))

"""
Splitting the data
"""

from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

print(merged_dummies.columns)


feature_columns = ['MonthlyIncome', 'Transaction Time', 'Female', 'Male', 'Tier 1', 'Tier 2', 'Tier 3']
x = merged_dummies[feature_columns]
y = merged_dummies['TotalSpend']


print(y.head())
print(x.head())

# Providing my seed
seed = 84
x_train_ujjwal, x_test_ujjwal, y_train_ujjwal, y_test_ujjwal = train_test_split(x, y, test_size = 0.35, random_state=seed)

# Fitting the model to training data
lr = LinearRegression()
lr.fit(x_train_ujjwal, y_train_ujjwal)

# Weight of the model
print("\nWeights")
print(lr.intercept_)

# coefficient
print(lr.coef_)

# Calling the model to get R square
print("\nR square value: ")
print(lr.score(x_train_ujjwal, y_train_ujjwal))
print()
print(lr.predict(x_test_ujjwal))

# Using Record again
columns = ['MonthlyIncome', 'Transaction Time', 'Female', 'Male', 'Tier 1', 'Tier 2', 'Tier 3', 'Record']
x1 = merged_dummies[columns]
y1 = merged_dummies['TotalSpend']

print(y1.head())
print(x1.head())


# Splitting the data again
x_train_ujjwal1, x_test_ujjwal1, y_train_ujjwal1, y_test_ujjwal1 = train_test_split(x1, y1, test_size = 0.35, random_state=seed)

# Fitting the model to training data
lr1 = LinearRegression()
lr1.fit(x_train_ujjwal1, y_train_ujjwal1)

# Weight of the model
print("\nWeights")
print(lr1.intercept_)

# coefficient
print(lr1.coef_)

# Calling the model to get R square
print("\nR square value")
print(lr1.score(x_train_ujjwal1, y_train_ujjwal1))
print()
print(lr1.predict(x_test_ujjwal1))

# # Plotting the data
# plt.plot(ecom_exp_ujjwal['MonthlyIncome'],ecom_exp_ujjwal['TotalSpend'], 'ro')
# plt.title('Monthly Income vs Total Spend')
# plt.plot(ecom_exp_ujjwal['Transaction Time'],ecom_exp_ujjwal['TotalSpend'], 'ro')
# plt.title('Transaction Time vs Total Spend')
# plt.plot(merged_dummy['Gender'],ecom_exp_ujjwal['TotalSpend'], 'ro')
# plt.title('Gender vs Total Spend')
# plt.plot(merged_dummy ['CityTier'],ecom_exp_ujjwal['TotalSpend'], 'ro')
# plt.title('City Tier vs Total Spend')

# Scatter plot for Monthly Income vs Total Spend
plt.figure(figsize=(10, 6))
plt.scatter(merged_dummies['MonthlyIncome'], merged_dummies['TotalSpend'], color='blue', alpha=0.5)
plt.title('Monthly Income vs Total Spend')
plt.xlabel('Monthly Income')
plt.ylabel('Total Spend')
plt.grid(True)
plt.show()

# Scatter plot for Transaction Time vs Total Spend
plt.figure(figsize=(10, 6))
plt.scatter(merged_dummies['Transaction Time'], merged_dummies['TotalSpend'], color='green', alpha=0.5)
plt.title('Transaction Time vs Total Spend')
plt.xlabel('Transaction Time')
plt.ylabel('Total Spend')
plt.grid(True)
plt.show()

# Scatter plot for Gender vs Total Spend (Assuming 'Female' and 'Male' as binary)
plt.figure(figsize=(10, 6))
plt.scatter(merged_dummies['Female'], merged_dummies['TotalSpend'], color='purple', alpha=0.5, label='Female')
plt.scatter(merged_dummies['Male'], merged_dummies['TotalSpend'], color='orange', alpha=0.5, label='Male')
plt.title('Gender vs Total Spend')
plt.xlabel('Gender')
plt.ylabel('Total Spend')
plt.legend()
plt.grid(True)
plt.show()

# Scatter plot for City Tier vs Total Spend (Assuming 'Tier 1', 'Tier 2', and 'Tier 3' as binary)
plt.figure(figsize=(10, 6))
plt.scatter(merged_dummies['Tier 1'], merged_dummies['TotalSpend'], color='red', alpha=0.5, label='Tier 1')
plt.scatter(merged_dummies['Tier 2'], merged_dummies['TotalSpend'], color='blue', alpha=0.5, label='Tier 2')
plt.scatter(merged_dummies['Tier 3'], merged_dummies['TotalSpend'], color='green', alpha=0.5, label='Tier 3')
plt.title('City Tier vs Total Spend')
plt.xlabel('City Tier')
plt.ylabel('Total Spend')
plt.legend()
plt.grid(True)
plt.show()



"""
Tried using differently, but failed. So I just took 2 dummy variables
"""

# # Using get_dummies to convert categorical columns into dummy variables
# ecom_exp_ujjwal_dummies = pd.get_dummies(ecom_exp_ujjwal, columns=categorical_columns)

# # print("\nWithout dummies")
# # # Displaying the column names
# # column_names = ecom_exp_ujjwal.columns
# # print("\nColumn Names: ")
# # print(column_names)
# # print("\nvalues: ")
# # print(ecom_exp_ujjwal)

# # print("\ndummies cloumn")
# # # Displaying the column names
# # column_names = ecom_exp_ujjwal_dummies.columns
# # print("\nColumn Names: ")
# # print(column_names)
# # print("\nvalues: ")
# # print(ecom_exp_ujjwal_dummies)

# # Attaching the new created variables
# ecom_exp_ujjwal = pd.concat([ecom_exp_ujjwal, ecom_exp_ujjwal_dummies], axis=1, join="inner")
# # column_names_categorical = ecom_exp_ujjwal.columns

# # print("\ndummies cloumn after concat")
# # # Displaying the column names
# # column_names = ecom_exp_ujjwal.columns
# # print("\nColumn Names: ")
# # print(column_names)
# # print("\nvalues: ")
# # print(ecom_exp_ujjwal)

# # Dropping the original categorical columns
# # No new dataframe is returned when inplace is true
# ecom_exp_ujjwal.drop(categorical_columns, axis=1, inplace=True)

# # print("\ndataframe cloumn after dropping categorical columns")
# # # Displaying the column names
# # column_names = ecom_exp_ujjwal.columns
# # print("\nColumn Names: ")
# # print(column_names)
# # print("\nvalues: ")
# # print(ecom_exp_ujjwal)

# # Function to normalize the data frame
# def normalize_dataframe(data_frame):
#     # Applying the normalization formula to each column
#     for column in data_frame.columns:
#         if data_frame[column].dtype in [int, float]:
#             x_min = data_frame[column].min()
#             x_max = data_frame[column].max()
#             data_frame[column] = (data_frame[column] - x_min) / (x_max - x_min)
#     return data_frame

# ecom_exp_ujjwal = normalize_dataframe(ecom_exp_ujjwal)
# # print(new_dataframe)

# # Displaying first two records
# first_two_records = ecom_exp_ujjwal.head(2)
# print(first_two_records)

# # Displaying the data in histogram
# # Setting the figure size
# plt.figure(figsize=(9, 10))

# # Generating the histogram
# ecom_exp_ujjwal.hist(bins=20, color='blue')
# # pd.plotting.scatter_matrix(df)
# plt.show()


# """
# Exercise 2: D
# """

# # Using the path and accessing the data
# path = "C:/"
# file_name = "ecomexp.csv"
# fullpath = os.path.join(path, file_name)

# # Reading the csv file
# ecom_exp_ujjwal_two = pd.read_csv(fullpath)

# # Extracting the variables
# X = [['Monthly Income', 'Transaction Time', 'dummy1', 'dummy2', 'dummy3', 'dummy4']]
# y = ecom_exp_ujjwal_two['Total Spend']