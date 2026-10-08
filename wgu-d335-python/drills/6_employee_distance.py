# DRILL 6 

# Three integers: number of trips for Employee A, B, C. Mileage rates:
# A=15.62, B=41.85, C=32.67 miles/trip. Output the combined total distance.
#
# Format:
#   Distance: total miles
#
# Example: 3, 10, 5 -> Distance: 628.71 miles

trips_a = int(input())
trips_b = int(input())
trips_c = int(input())

distance_for_a = trips_a * 15.62
distance_for_b = trips_b * 41.85
distance_for_c = trips_c * 32.67

total_distance = distance_for_a + distance_for_b + distance_for_c

print(f"Distance: {total_distance:.2f} miles")

