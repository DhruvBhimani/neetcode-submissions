class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        // 1. Edge Case: If there are no cars, there are 0 fleets
        if (position.length == 0 || position.length != speed.length) 
        {
            return 0;
        }

        // 2. Put positions and speeds into a TreeMap (Automatically sorts from back to front)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) 
        {
            map.put(position[i], speed[i]);
        }

        // 3. Start at the absolute frontmost car (the last entry in the TreeMap)
        Map.Entry<Integer, Integer> currentCar = map.lastEntry();
        
        // Calculate the time it takes for this leader car to hit the target
        // (target - position) / speed -> we use double to avoid integer rounding bugs
        double leaderTime = (double)(target - currentCar.getKey()) / currentCar.getValue();
        
        // A single car is already at least 1 fleet
        int fleetCount = 1; 

        // 4. Step backward through the remaining cars one by one
        while (map.lowerEntry(currentCar.getKey()) != null) 
        {
            // Move our pointer to the next car behind us (the 2nd last, then 3rd last, etc.)
            currentCar = map.lowerEntry(currentCar.getKey());
            
            // Calculate time for this trailing car
            double behindCarTime = (double)(target - currentCar.getKey()) / currentCar.getValue();

            // IF the car behind takes MORE time than the leader, it CANNOT catch up!
            // It forms its own brand-new fleet, and becomes the new leader for cars behind it.
            if (behindCarTime > leaderTime) 
            {
                fleetCount++;
                leaderTime = behindCarTime; // Update the bottleneck fleet time
            }
            // ELSE (behindCarTime <= leaderTime): It catches up and joins the fleet!
            // We do nothing because it merges into the existing leader's fleet.
        }

        return fleetCount;
    }
}
