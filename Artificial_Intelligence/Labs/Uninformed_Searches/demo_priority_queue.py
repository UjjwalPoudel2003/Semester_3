# -*- coding: utf-8 -*-
"""
Created on Wed Jul 15 11:30:06 2020

@author: mhabayeb
"""

import queue

pqueue = queue.PriorityQueue()
print (pqueue.qsize())

pqueue.put((5, 'A'))
pqueue.put((10, 'B'))
pqueue.put((1, 'C'))
pqueue.put((5, 'D'))

print (pqueue.qsize())

while not pqueue.empty(): 
    print (pqueue.get())
    
print (pqueue.qsize())