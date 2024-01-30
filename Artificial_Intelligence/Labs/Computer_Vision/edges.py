# -*- coding: utf-8 -*-
"""
Created on Fri Sep  4 10:59:53 2020

@author: mhabayeb
"""

#Edge detection
import cv2
import numpy as np
path_to_image = r'C:\\Users\\mhabayeb\\Documents\\M2_agent_robot.png'
# Load an color image in grayscale
img = cv2.imread(path_to_image,cv2.IMREAD_UNCHANGED)
#Show the colored image
#cv2.imshow('Original',img)
#Convert the colored image into grey and store into a separte variable then show
gray_img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
"""
The Canny edge detector was developed way back in 1986 by John F. Canny.
 And it’s still widely used today was one of the default edge detectors
 in image processing.
The Canny edge detection algorithm can be broken down into 5 steps:
Step 1: Smooth the image using a Gaussian filter to remove high frequency noise.
Step 2: Compute the gradient intensity representations of the image.
Step 3: Apply non-maximum suppression to remove “false” responses to to edge detection.
Step 4: Apply thresholding using a lower and upper boundary on the gradient values.
Step 5: Track edges using hysteresis by suppressing weak edges 
that are not connected to strong edges.
OpenCV implementation of the Canny edge detector: 
cv2.canny(image, lower, upper)
Where image  is the image that we want to detect edges in; 
and lower  and upper  are our integer thresholds for Step 4, respectively.
https://www.pyimagesearch.com/2015/04/06/zero-parameter-automatic-canny-edge-detection-with-python-and-opencv/
"""
# Using the Canny filter to get contours
edges = cv2.Canny(gray_img, 20, 30)
# Using the Canny filter with different parameters
edges_high_thresh = cv2.Canny(gray_img, 60, 120)
# Stacking the images to print them together
# For comparison
"""
#This function makes most sense for arrays with up to 3 dimensions. 
For instance, for pixel-data with a height (first axis), width (second axis), 
and r/g/b channels (third axis). The functions concatenate, stack and block 
provide more general stacking and concatenation operations.
"""
images = np.hstack((gray_img, edges, edges_high_thresh))

# Display the resulting frame
cv2.imshow('Frame', images)
"""
#he waitKey function, which will wait for a keyboard event.
#This function receives as input a delay, specified in milliseconds. 
#Nonetheless, if we pass the value 0, then it will wait indefinitely until
# a key event occurs.
"""
cv2.waitKey(0)
"""
#once the user pressed a key, we call the destroyAllWindows function,
# which will destroy the previously created windows.
"""
cv2.destroyAllWindows()

