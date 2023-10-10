from Node import Node
from state import State
from collections import deque
from classmate_search import *

def BFS_Ujjwal(graph_name, initial_person, goal_person):
    """
    This function performs BFS search using a queue
    """
    State.graph = graph_name
    State.initial_state = initial_person
    
    if initial_person in graph_name and goal_person in graph_name:
        #create queue
        queue = deque([]) 
        #since it is a graph, we create visited list
        visited = [] 
        #create root node
        initialState = State()
        
        root = Node(initialState)
        #add to queue and visited list
        queue.append(root)
        visited.append(root.state.name)
        # check if there is something in queue to dequeue
        while len(queue) > 0:
            
            #get first item in queue
            currentNode = queue.popleft()
            
            print (("-- dequeue --"), currentNode.state.name)
            
            #check if this is goal state
            if currentNode.state.checkGoalState(goal_person):
                print ("reached goal state")
                #print the path
                print ("----------------------")
                print ("Path")
                currentNode.printPath()
                break           
            #get the child nodes 
            childStates = currentNode.state.successorFunction()
            for childState in childStates:
                
                childNode = Node(State(childState))
                
                #check if node is not visited
                if childNode.state.name not in visited:
                    
                    #add this node to visited nodes
                    visited.append(childNode.state.name)
                    
                    
                    #add to tree and queue
                    currentNode.addChild(childNode)
                    queue.append(childNode)
                            
        #print tree
        print ("----------------------")
        print ("Tree")
        root.printTree()
    
    else:
        print("The names entered cannot be found in the graph")
        
# BFS_Ujjwal(connections, "dolly", "ujjwal")
BFS_Ujjwal(connections, "george", "bob")
