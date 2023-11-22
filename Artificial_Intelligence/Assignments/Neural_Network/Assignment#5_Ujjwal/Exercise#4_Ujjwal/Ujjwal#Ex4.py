import numpy as np
import neurolab as nl
import matplotlib.pyplot as plt

input_Ujjwal = np.random.uniform(low=-0.6, high=0.6, size=(100,2))
print(input_Ujjwal)
output_Ujjwal = input_Ujjwal.sum(axis=1).reshape(100,1)
print(output_Ujjwal)
np.random.seed(1)
nn = nl.net.newff([[-0.6, 0.6], [-0.6, 0.6]], [5, 3, 1])
nn.trainf = nl.train.train_gd
error_progress = nn.train(input_Ujjwal, output_Ujjwal, epochs=1000, show=100, goal=0.00001)

plt.figure()
plt.plot(error_progress)
plt.xlabel("epochs")
plt.ylabel("error")
plt.title("error progress")

test_data = [[0.1, 0.2]]
result4 = nn.sim(test_data)
print(result4)