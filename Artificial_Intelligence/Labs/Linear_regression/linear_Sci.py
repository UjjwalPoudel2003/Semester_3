# -*- coding: utf-8 -*-
"""
Created on Tue Nov  5 12:39:34 2019

@author: mhabayeb
"""
# Load the data
import pandas as pd
import os
path = "H:/Semester_3/Artificial_Intelligence/Labs/Linear_regression/"
filename = 'Advertising.csv'
fullpath = os.path.join(path,filename)
data_mayy_adv = pd.read_csv(fullpath)
# Check the data
data_mayy_adv.columns.values
data_mayy_adv.shape
data_mayy_adv.describe()
data_mayy_adv.dtypes
data_mayy_adv.head(5)
#####
# Plot the data
###
import matplotlib.pyplot as plt
plt.plot(data_mayy_adv['TV'],data_mayy_adv['Sales'],'ro')
plt.title('TV vs Sales')
plt.plot(data_mayy_adv['Radio'],data_mayy_adv['Sales'],'ro')
plt.title('Radio vs Sales')
plt.plot(data_mayy_adv['Newspaper'],data_mayy_adv['Sales'],'ro')
plt.title('Newspaper vs Sales')
#####
#split the data
#####
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
feature_cols = ['TV', 'Radio']
X = data_mayy_adv[feature_cols]
Y = data_mayy_adv['Sales']
print(Y.head())
print(X.head())
###
trainX,testX,trainY,testY = train_test_split(X,Y, test_size = 0.2)
lm = LinearRegression()
lm.fit(trainX, trainY)
print (lm.intercept_)
print (lm.coef_)
###
lm.score(trainX, trainY)
lm.predict(testX)
####
from sklearn.feature_selection import RFE
from sklearn.svm import SVR
feature_cols = ['TV', 'Radio','Newspaper']
X = data_mayy_adv[feature_cols]
Y = data_mayy_adv['Sales']
estimator = SVR(kernel="linear")
selector = RFE(estimator,2,step=1)
selector = selector.fit(X, Y)
print(selector.support_)
print(selector.ranking_)








    