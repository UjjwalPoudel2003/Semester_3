# from classmate_search import *

class State:
    '''
    This class retrieves state information for social connection feature
    '''
    
    # Creating class variables
    graph = {}
    initial_state = ""
    
    def __init__(self, name = None):
        if name == None:
            #create initial state
            self.name = self.getInitialState()
        else:
            self.name = name
            
    # def setName(self, initial_name):
    #     State.initial_state = initial_name
    
    # def setGraph(self, graph):
    #     State.graph = graph
    
    def getInitialState(self):
        """
        This method returns me.
        """
        initialState = State.initial_state
        return initialState

    def successorFunction(self):
        """
        This is the successor function. It finds all the persons connected to the
        current person
        """
        return State.graph[self.name]
        
    def checkGoalState(self, goal_person):
        """
        This method checks whether the person is the target person(i.e. Goal person)
        """ 
        return self.name == goal_person