import numpy as np
import neurolab as nl

input_Ujjwal = np.random.uniform(low=-0.6, high=0.6, size=(100,2))
print(input_Ujjwal)
output_Ujjwal = input_Ujjwal.sum(axis=1).reshape(100,1)
print(output_Ujjwal)
np.random.seed(1)
nn = nl.net.newff([[-0.6, 0.6], [-0.6, 0.6]], [6, 1])
error_progress = nn.train(input_Ujjwal, output_Ujjwal, show=15, goal=0.00001)
test_data = [[0.1, 0.2]]
result3 = nn.sim(test_data)
print(result3)