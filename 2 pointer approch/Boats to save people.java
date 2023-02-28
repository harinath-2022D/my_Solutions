int boatCount=0;
		  Arrays.sort(people);
		  int low = 0;
		  int high = people.length-1;
		  while(low<=high){
			  if(people[low]+people[high]<=limit){
				  low++;
			  }
			  high--;
			  boatCount++;
		  }
		  return boatCount;
