package ArrayList

import "errors"

//定义一个接口
type List interface {
	//首字母大写表示public
	Size() int //数组大小
	//interface是返回一个泛型
	Get(index int) (interface{}, error)        //获取指定下标的元素
	Set(index int, newval interface{}) error   //修改指定下标的数据
	Insert(index int, value interface{}) error //插入一个数据
	Append(value interface{})                  //追加
	Clear()                                    //清空
	Delete(index int) error                    //删除
	String() string
}

//定义一个结构体
type ArrayList struct {
	//定义一个泛型数组变量
	dataStore []interface{}
	theSize   int //数组长度
}

//初始化一个ArrayList,并返回数据的指针
func NewArrayList() *ArrayList {
	list := new(ArrayList)
	list.dataStore = make([]interface{}, 0, 10)
	list.theSize = 0
	return list
}

//返回数组大小，因为需要包装在ArrayList里面
func (list *ArrayList) Size() int {
	return list.theSize
}

//获取指定下标的
func (list *ArrayList) Get(index int) (interface{}, error) {
	if index < 0 || index >= list.theSize {
		return nil, errors.New("索引越界")
	}
	return list.dataStore[index], nil
}

//追加
func (list *ArrayList) Append(value interface{}) {
	list.dataStore = append(list.dataStore, value) //叠加数据
	list.theSize++
}

func (list *ArrayList) String() string {

}
