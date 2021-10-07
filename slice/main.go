package main

import "fmt"

func main() {
	mySlice := []string{"I","am","stupid","and","weak"}
	fmt.Printf("mySlice %s\n", mySlice)
	for index, _ := range mySlice {
		fmt.Printf("%s ", mySlice[index])
	}
	fmt.Printf("\n")
	for index, _ := range mySlice {
		if index == 2 {
			mySlice[index] = "smart"
		}
		if index == 4 {
			mySlice[index] = "strong"
		}
	}
	for index, _ := range mySlice {
		fmt.Printf("%s ", mySlice[index])
	}
	fmt.Printf("\n")
	for _, value := range mySlice {
		fmt.Printf("%s ", value)
	}

}