# Importing the data
import pandas as pd
import os

# Declaring the path
path = "C:/Users/301284284/Downloads/Semester_3/Artificial_Intelligence/Practice_test/Midterm/"
file_name = "student-mat.csv"

# Joining and displaying the data
full_path = os.path.join(path, file_name)
student_data = pd.read_csv(full_path, sep=";")
# print(student_data)

# Displaying all the columns
print(student_data.columns.values)

# Describing the data
print(student_data.describe())

# importing matplot library
import matplotlib.pyplot as plt
plt.plot(student_data['school'], student_data['age'])
plt.title("School vs Age")

plt.plot(student_data['school'], student_data['sex'])
# plt.hist(student_data['school'], bins=20)
plt.title("School vs Sex")

# Using crosstab to display sex vs studytime
pd.crosstab(student_data.sex, student_data.studytime).plot(kind="bar")
plt.title("Sex vs Studytime")
plt.xlabel("F for female, M for male (Sex)")
plt.ylabel("No. of students")

# Using linegraph to show the relation between studytime  and failures
plt.plot(student_data['studytime'], student_data['failures'])
plt.title("studytime vs failures")
plt.xlabel("Studytime per week")
plt.ylabel("no of past class failures")

# using crosstab to display school vs no of student absences
pd.crosstab(student_data.school, student_data.absences).plot(kind="bar")
plt.title("Name of school vs No. of absences")
plt.xlabel("Name of school, GP and MS")
plt.ylabel("No. of absences")

# Using crosstab to display the reason of students joining the schools
pd.crosstab(student_data.school, student_data.reason).plot(kind="bar")
plt.title("School vs Reason to join")
plt.xlabel("School Names GP and MS")
plt.ylabel("No. of students")


# Absences and G3
plt.scatter(student_data['absences'], student_data['G3'])
plt.show()

# G3 distribution using hist
plt.hist(student_data['G3'])
plt.show()

# Using crosstab to show the relation between family size and g3
pd.crosstab(student_data.famsize, student_data.G3).plot(kind="bar")
plt.title("Family size vs G3")

import numpy as np
student_data['schoolsup'] = np.where(student_data['schoolsup'] == 'yes', 1, student_data['schoolsup'])
student_data['schoolsup'] = np.where(student_data['schoolsup'] == 'no', 0, student_data['schoolsup'])

for i in ['famsup', 'paid', 'activities', 'nursery', 'higher', 'internet', 'romantic']:
    student_data[i] = np.where(student_data[i] == 'yes', 1, student_data[i])
    student_data[i] = np.where(student_data[i] == 'no', 0, student_data[i])
    