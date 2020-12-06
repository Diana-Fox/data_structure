package main

import (
	"./ArrayList"
	"fmt"
)

func main() {
	mystack := ArrayList.NewArrayListStackX()
	mystack.Push(1)
	mystack.Push(2)
	mystack.Push(3)
	mystack.Push(4)
	for it := mystack.Myit; it.HasNext(); {
		item, _ := it.Next()
		fmt.Println(item)
	}
}

func main4() {
	//mystack:=ArrayList.NewArrayListStack()//:= StackArray.NewStack()
	mystack := ArrayList.NewArrayListStackX()
	mystack.Push(1)
	mystack.Push(2)
	mystack.Push(3)
	mystack.Push(4)
	fmt.Println(mystack.Pop())
	fmt.Println(mystack.Pop())
	fmt.Println(mystack.Pop())
	fmt.Println(mystack.Pop())
}
func main2() {
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
