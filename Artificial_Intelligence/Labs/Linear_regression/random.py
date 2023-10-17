# -*- coding: utf-8 -*-
"""
Created on Mon Jul 27 14:51:52 2020

@author: mhabayeb
"""
###########################################
import numpy as np
#generating a random integer between 1 and 10
np.random.randint(1,10)
############################################
#To generate a random number between 0 and 1
np.random.random()
########################################
#The seed
np.random.seed(1)
for i in range(5):
    print (np.random.random())
########################################
#define a function to generate a series of numbers
def randint_range(n,a,b):
    x=[]
    for i in range(n):
        x.append(np.random.randint(a,b))
    return x

randint_range(6,22,100)

########################################
#To generate three random numbers between 0 and 100
import random
for i in range(3):
    print (random.randrange(0,100,10)) 
########################################
#The randn function of the random method is used to generate 
#random numbers following a normal distribution.
import numpy as np
import matplotlib.pyplot as plt
a=np.random.randn(1000)
type(a)
plt.hist(a)
##########################################
# The uniform distribution
import numpy as np
import matplotlib.pyplot as plt
b=np.random.uniform(1,10000,10000)
plt.hist(b)


########################################
#Train test split
###############################
import pandas as pd
import os
import matplotlib.pyplot as plt 
path = "C:/Users/mhabayeb/Documents/courses_cen/COMP309 new/data/"
filename = 'Advertising.csv'
fullpath = os.path.join(path,filename)
data = pd.read_csv(fullpath)
####
a=np.random.randn(len(data))

print(a)

plt.hist(a, bins = 10)
plt.show()

check = a<0.8

print(check)
training = data[check]
testing = data[~check]
len(training)
len(testing)

############################
