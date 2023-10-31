# -*- coding: utf-8 -*-
"""
Created on Mon Oct 30 08:40:25 2023

@author: 301284284
"""

# Exploring the data
import pandas as pd
import os
path = "C:/Users/301284284/Downloads/Semester_3/Artificial_Intelligence/Assignments/test_midterm"
filename = 'car.csv'
fullpath = os.path.join(path,filename)
df_ujjwal = pd.read_csv(fullpath)
print(df_ujjwal)

print(df_ujjwal.columns.values)
print(df_ujjwal.dtypes)
print(df_ujjwal.Fuel_Type.unique)
print(df_ujjwal.describe())
print(df_ujjwal.head(4))
print(df_ujjwal.info())

# Visualizing the data

# Plotting year in histogram
from matplotlib import pyplot as plt
plt.hist(df_ujjwal['Year'], bins=(10))
plt.title("ujjwal_Year")
plt.xlabel('Years')
plt.ylabel('No. of cars')

# Plotting scatterplot Kms_Driven versus Selling Price
plt.scatter(df_ujjwal['Kms_Driven'], df_ujjwal['Selling_Price'])
plt.title("ujjwal_YK_scatter")
plt.xlabel('No of Kms driven')
plt.ylabel('Selling Price')

# Creating a bar plot for the transmission column for each year
plt.bar(df_ujjwal['Year'], df_ujjwal['Transmission'])
plt.xlabel('No. of year')
plt.ylabel('Transmission type')

"""
Pre-processing the data
"""
df_ujjwal.dropna(axis=1, inplace=True)
age = []
for x in df_ujjwal['Year']:
    age_of_car = (x - 1999)
    print(age_of_car)
    age.append(age_of_car)
    
print(age)

df_ujjwal['Age']= age
df_ujjwal.drop(['Car_Name'], axis=1, inplace=True)
df_ujjwal.drop(['Year'], axis=1, inplace=True)
cat_vars = ['Fuel_Type', 'Seller_Type', 'Transmission']
for var in cat_vars:
    cat_list='var'+'_'+var
    print(cat_list)
    cat_list = pd.get_dummies(df_ujjwal[var], prefix=var)
    new_df_ujjwal=df_ujjwal.join(cat_list)
    df_ujjwal = new_df_ujjwal

df_ujjwal.drop(cat_vars, axis=1, inplace=True)

df_ujjwal_numeric = df_ujjwal
print(df_ujjwal_numeric.dtypes)

from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

model_ujjwal =  LinearRegression()
feature_cols = ['Present_Price', 'Kms_Driven', 'Owner', 'Age', 'Fuel_Type_CNG', 'Fuel_Type_Diesel',
                'Fuel_Type_Petrol', 'Seller_Type_Dealer', 'Seller_Type_Individual', 'Transmission_Automatic',
                'Transmission_Manual']

X = df_ujjwal_numeric[feature_cols]
Y = df_ujjwal_numeric['Selling_Price']

print(X)
print(Y)

seed = 84
trainX,testX,trainY,testY = train_test_split(X,Y, test_size = 0.25, random_state=(seed))
model_ujjwal.fit(trainX, trainY)

# Printing intercept and coefficient
print ("Intercept: ", model_ujjwal.intercept_)
print ("Coefficient: ",model_ujjwal.coef_)

# Predicting the data
y_pred = model_ujjwal.predict(testX)
print(y_pred)
model_ujjwal.score(testX, testY)

y_true = testY['Selling_Price'].values
from sklearn.metrics import r2_score
r_squared = r2_score(y_true, y_pred)

print("Length of testY: ", len(testY))
print("Length of y_pred: ", len(y_pred))
