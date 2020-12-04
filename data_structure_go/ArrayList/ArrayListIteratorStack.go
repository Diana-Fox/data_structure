package ArrayList

type StackArrayX interface {
	Clean()                //清空
	Size() int             //大小
	Pop() interface{}      //出栈
	Push(data interface{}) //入栈
	IsFull() bool          //是否满了
	IsEmpty() bool         //是否为空
}
type StackX struct {
	myarray *ArrayList
	Myit    Iterator
}

//初始化一個Stack
func NewArrayListStackX() *StackX {
	mystack := new(StackX)
	//初始化List
	mystack.myarray = NewArrayList()
	//初始化Iterator
	mystack.Myit = mystack.myarray.Iterator()
	return mystack
}

func (mystack *StackX) Clean() { //清空
	mystack.myarray.Clear()
	mystack.myarray.theSize = 0
}
func (mystack *StackX) Size() int { //大小
	return mystack.myarray.theSize
}
func (mystack *StackX) Pop() interface{} { //出栈
	if !mystack.IsEmpty() {
		last := mystack.myarray.dataStore[mystack.myarray.theSize-1]
		mystack.myarray.Delete(mystack.myarray.theSize - 1)
		return last
	}

	return nil
}
func (mystack *StackX) Push(data interface{}) { //入栈
	if !mystack.IsFull() {
		mystack.myarray.Append(data)
	}
}
func (mystack *StackX) IsFull() bool { //是否满了
	return mystack.myarray.theSize == 10
}
func (mystack *StackX) IsEmpty() bool {
	return mystack.myarray.theSize == 0
}
