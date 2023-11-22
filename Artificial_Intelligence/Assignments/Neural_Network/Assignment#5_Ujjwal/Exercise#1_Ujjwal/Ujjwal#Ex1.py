import numpy as np
import neurolab as nl

# Set seed for reproducibility
np.random.seed(1)

# Task 2: Generate input data
input_Ujjwal = np.random.uniform(-0.6, 0.6, size=(10, 2))

# Task 3: Create target data (output)
output_Ujjwal = np.sum(input_Ujjwal, axis=1).reshape(-1, 1)

# Task 5: Create a simple neural network
net = nl.net.newff([[min(input_Ujjwal[:, 0]), max(input_Ujjwal[:, 0])],
                    [min(input_Ujjwal[:, 1]), max(input_Ujjwal[:, 1])]],
                   [6, 1])

# Task 6: Train the network
error = net.train(input_Ujjwal, output_Ujjwal, epochs=1000, show=15, goal=0.00001)

# Task 8: Test the network with new values (0.1 and 0.2)
test_values = np.array([[0.1, 0.2]])
result = net.sim(test_values)

# Display the results
print("\nTrained Neural Network Weights and Biases:")
print("Weights:", net.layers[0].np['w'])
print("Biases:", net.layers[0].np['b'])

print("\nTraining Error:", error[-1])

print("\nTest Result #1:")
print("Input:", test_values)
print("Output:", result)
