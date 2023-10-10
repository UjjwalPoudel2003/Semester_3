# -*- coding: utf-8 -*-
"""
Created on Thu Oct 2 15:51:14 2023

@author: ujjwal
"""

connections = {}
connections["adam"] = ["ema", "ujjwal", "bob"]
connections["ema"] = ["adam", "dolly", "bob"]
connections["ujjwal"] = ["adam", "frank", "george"]
connections["bob"] = ["ema", "dolly", "adam"]
connections["george"] = ["ujjwal"]
connections["frank"] = ["ujjwal"]
connections["dolly"] = ["bob", "ema"]