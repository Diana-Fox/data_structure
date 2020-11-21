package main

import (
	"./ArrayList"
	"fmt"
)

func main() {
	var list ArrayList.List = ArrayList.NewArrayList()
	list.Append("a")
	list.Append("b")
	list.Append("c")
	list.Append("d")
	for it := list.Iterator(); it.HasNext(); {
		item, _ := it.Next()
		fmt.Println(item)
	}

}
func main1() {
	list := ArrayList.NewArrayList()
	list.Append("a")
	fmt.Print(list)
}
