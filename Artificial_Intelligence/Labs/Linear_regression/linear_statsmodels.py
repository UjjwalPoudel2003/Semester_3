# -*- coding: utf-8 -*-
"""
Created on Tue Nov  5 12:39:34 2019

@author: mhabayeb
"""
#Load the data
import pandas as pd
import os
path = 'H:/Semester_3/Artificial_Intelligence/Labs/Linear_regression/'
filename = 'Advertising.csv'
fullpath = os.path.join(path,filename)
data_mayy_adv = pd.read_csv(fullpath)
###
###Check the data
data_mayy_adv.columns.values
data_mayy_adv.shape
data_mayy_adv.describe()
data_mayy_adv.dtypes
data_mayy_adv.head(5)
#####
###plot the data
import matplotlib.pyplot as plt
plt.plot(data_mayy_adv['TV'],data_mayy_adv['Sales'],'ro')
plt.title('TV vs Sales')
plt.plot(data_mayy_adv['Radio'],data_mayy_adv['Sales'],'ro')
plt.title('Radio vs Sales')
plt.plot(data_mayy_adv['Newspaper'],data_mayy_adv['Sales'],'ro')
plt.title('Newspaper vs Sales')
#####
##Build the model with one variable
###
import statsmodels.formula.api as smf
model1=smf.ols(formula='Sales~TV',data=data_mayy_adv).fit()
model1.params	
####
print(model1.pvalues)
print(model1.rsquared)
print(model1.summary())
####Buil with 2 parameters
import statsmodels.formula.api as smf
model2=smf.ols(formula='Sales~TV+Radio',data=data_mayy_adv).fit()
print(model2.params)
print(model2.rsquared)
print(model2.summary())
#### Predict
X_new2 = pd.DataFrame({'TV': [50],'Radio' : [40]})
print(X_new2)
# predict for a new observation
sales_pred2=model2.predict(X_new2)
print(sales_pred2)
#####









    