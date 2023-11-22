import numpy as np
import neurolab as nl

input_Ujjwal = np.random.uniform(low=-0.6, high=0.6, size=(10,2))
print(input_Ujjwal)
output_Ujjwal = input_Ujjwal.sum(axis=1).reshape(10,1)
print(output_Ujjwal)
np.random.seed(1)
nn = nl.net.newff([[-0.6, 0.6], [-0.6, 0.6]], [5, 3, 1])
nn.trainf = nl.train.train_gd
error_progress = nn.train(input_Ujjwal, output_Ujjwal, epochs=1000, show=100, goal=0.00001)
test_data = [[0.1, 0.2]]
result2 = nn.sim(test_data)
print(result2)