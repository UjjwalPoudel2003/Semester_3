# -*- coding: utf-8 -*-
"""
Created on Thu Oct 08 19:22:29 2023

@author: ujjwal
"""

"""
Before adding the noise
"""
# Imports
import numpy as np
import matplotlib.pyplot as plt

# Providing seed, 84 from 301284284
np.random.seed(84)

# Generating random 100 uniform values from 0 to 1 
x = np.random.uniform(0, 1, 100)

# Setting the Y value
y = 12 * x - 4

# Displaying the y value
print(y)
    
# Setting the plots title and labels
plt.title("Sampling 100 random uniform data (Before Noise)")
plt.xlabel("x-value (random numbers 0 to 1)")
plt.ylabel("y-value (y = 12 x X - 4)")

# Showing the plot
plt.scatter(x, y, alpha=0.5, color="blue", s=5)
plt.show()

"""
After Adding the Noise
"""
# Adding the noise to the y distribution
noise = np.random.uniform(0, 0.1, len(y))
y += noise

# Displaying the y value
print(y)

# Setting the plots title and labels
plt.title("Sampling 100 random uniform data (After Noise)")
plt.xlabel("x-value (random numbers 0 to 1)")
plt.ylabel("y-value (y = 12 x X - 4 + Noise)")

# Displaying the graph
plt.scatter(x, y, alpha=0.5, color="green", s=5)
plt.show()