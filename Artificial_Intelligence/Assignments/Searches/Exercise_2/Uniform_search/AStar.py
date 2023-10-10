from State import State
from Node import Node
import queue
from TreePlot import TreePlot
    

def performUniformCostSearch():
    """
    This method performs Uniform cost search
    """
    
    #creating priority queue
    pqueue = queue.PriorityQueue()
    
    #create root node
    initialState = State()
    root = Node(initialState, None)
    
    #show the search tree explored so far
    treeplot = TreePlot()
    treeplot.generateDiagram(root, root)
    
    #addding the root node in the queue
    pqueue.put((root.costFromRoot, root))
    
    #check if there is something in queue to remove
    while not pqueue.empty():
        
        #dequeue nodes from the priority Queue
        _, currentNode = pqueue.get()
        
        #remove from the fringe
        currentNode.fringe = False
        
        #check if it has goal State
        print ("-- dequeue --", currentNode.state.place)
        
        #check if this is goal state
        if currentNode.state.checkGoalState():
            print ("reached goal state")
            #print the path
            print ("----------------------")
            print ("Path")
            currentNode.printPath()
            
            #show the search tree explored so far
            treeplot = TreePlot()
            treeplot.generateDiagram(root, currentNode)
            break
            
        #get the child nodes 
        childStates = currentNode.state.successorFunction()
        for childState in childStates:
            
            childNode = Node(State(childState), currentNode)
            childNodeCost = childNode.computeCost()
            
            #add to tree and queue, again we put the less cost from root
            pqueue.put((childNodeCost, childNode))
            
        #show the search tree explored so far
        treeplot = TreePlot()
        treeplot.generateDiagram(root, currentNode)
        
                
    #print tree
    print ("----------------------")
    print ("Tree")
    root.printTree()
    
performUniformCostSearch()