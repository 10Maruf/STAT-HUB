# import random
# import csv

# # Set the file path where you want to save the file
# file_path = 'one_sample_t_test_data.csv'

# # Generate 1000 random data points (for example, mean = 50, stddev = 10)
# data = [random.normalvariate(50, 10) for _ in range(1000)]

# # Write the data to a CSV file
# with open(file_path, 'w', newline='') as file:
#     writer = csv.writer(file)
#     # Write the data as one row of comma-separated values
#     writer.writerow(data)  # Writes all 1000 data points in a single row

# print(f"CSV file with one sample t-test data has been created at: {file_path}")
# import random
# import csv

# # Set the file path where you want to save the file
# file_path = 'one_way_anova_10_groups.csv'

# # Generate 10 groups of data for One-Way ANOVA (e.g., group sizes: 30 each)
# groups = []
# means = [50, 55, 60, 45, 47, 52, 58, 59, 63, 62]  # Example means for each group
# stddev = 10  # Standard deviation for each group (can be modified for variance)

# # Create 10 groups of 30 data points each
# for mean in means:
#     group = [random.normalvariate(mean, stddev) for _ in range(50)]
#     groups.append(group)

# # Write the data to a CSV file
# with open(file_path, 'w', newline='') as file:
#     writer = csv.writer(file)
#     # Write header with group names (Group 1, Group 2, ..., Group 10)
#     header = [f'Group {i+1}' for i in range(10)]
#     writer.writerow(header)
    
#     # Write data for each group in a row, using zip to combine corresponding elements from each group
#     for row in zip(*groups):  # Unpack each group and write a row for each data point
#         writer.writerow(row)

# print(f"CSV file with One-Way ANOVA data for 10 groups has been created at: {file_path}")


# import random
# import csv

# # Set the file path to save the dataset
# file_path = 'chi_square_test_data.csv'

# # Parameters for the dataset
# rows = 200
# cols = 5

# # Generate random integer data for the dataset
# data = [[random.randint(1, 100) for _ in range(cols)] for _ in range(rows)]

# # Write the data to a CSV file
# with open(file_path, 'w', newline='') as file:
#     writer = csv.writer(file)
#     # Write header (optional, e.g., Column 1, Column 2, ...)
#     header = [f'Column {i+1}' for i in range(cols)]
#     writer.writerow(header)
    
#     # Write each row of data
#     writer.writerows(data)

# print(f"CSV file with Chi-Square test data (200 rows, 5 columns) has been created at: {file_path}")

# import csv
# import random

# # Create 500 observed and expected values
# observed_values = [random.randint(50, 150) for _ in range(500)]
# expected_values = [random.randint(50, 150) for _ in range(500)]

# # Write to observed.csv
# with open('observed.csv', mode='w', newline='') as file:
#     writer = csv.writer(file)
#     writer.writerow(["Observed"])
#     writer.writerow(observed_values)  # Write all values in one row

# # Write to expected.csv
# with open('expected.csv', mode='w', newline='') as file:
#     writer = csv.writer(file)
#     writer.writerow(["Expected"])
#     writer.writerow(expected_values)  # Write all values in one row

# print("observed.csv and expected.csv created successfully.")

# import csv
# import random

# # Parameters for the linear equation y = mx + b
# m = 2.5  # Slope
# b = 5    # Intercept

# # Generate 400 x, y pairs for simple linear regression
# data = []
# for _ in range(400):
#     x = random.randint(1, 100)  # Random x value between 1 and 100
#     noise = random.uniform(-5, 5)  # Adding some noise to the y value
#     y = m * x + b + noise
#     data.append([x, y])

# # Write to linear_regression.csv
# with open('linear_regression.csv', mode='w', newline='') as file:
#     writer = csv.writer(file)
#     writer.writerow(["x", "y"])  # Header row
#     writer.writerows(data)  # Data rows

# print("linear_regression.csv created successfully.")


import csv
import random

# Coefficients for the polynomial (a0, a1, ..., a10)
coefficients = [random.uniform(-1, 1) for _ in range(11)]  # Random coefficients

# Generate 1000 data points
data = []
for _ in range(1000):
    x = random.uniform(-10, 10)  # Random x value between -10 and 10
    y = sum(coefficients[i] * (x ** i) for i in range(11))  # Calculate y using the polynomial
    y += random.uniform(-5, 5)  # Add noise to y
    data.append([x, y])

# Write to polynomial_data.csv
with open('polynomial_data.csv', mode='w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(["x", "y"])  # Header row
    writer.writerows(data)  # Data rows

print("polynomial_data.csv created successfully.")
