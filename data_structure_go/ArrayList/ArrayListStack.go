package ArrayList

type StackArray interface {
	Clean()                //清空
	Size() int             //大小
	Pop() interface{}      //出栈
	Push(data interface{}) //入栈
	IsFull() bool          //是否满了
	IsEmpty() bool         //是否为空
}
type Stack struct {
	myarray *ArrayList
	capsize int //最大范围
}

func NewArrayListStack() *Stack {
	mystack := new(Stack)
	mystack.myarray = NewArrayList()
	mystack.capsize = 10
	return mystack
}

func (mystack *Stack) Clean() { //清空
	mystack.myarray.Clear()
	mystack.capsize = 10
}
func (mystack *Stack) Size() int { //大小
	return mystack.myarray.theSize
}
func (mystack *Stack) Pop() interface{} { //出栈
	if !mystack.IsEmpty() {
		last := mystack.myarray.dataStore[mystack.myarray.theSize-1]
		mystack.myarray.Delete(mystack.myarray.theSize - 1)

		return last
	}

	return nil
}
func (mystack *Stack) Push(data interface{}) { //入栈
	if !mystack.IsFull() {
		mystack.myarray.Append(data)
	}
}
func (mystack *Stack) IsFull() bool { //是否满了
	return mystack.myarray.theSize == mystack.capsize
}
func (mystack *Stack) IsEmpty() bool {
	return mystack.myarray.theSize == 0
}
