package main

import (
	"errors"
	"fmt"
	"io/ioutil"
)

//遍历文件下所有目录
func GetAll(path string, files []string) ([]string, error) {
	read, err := ioutil.ReadDir(path) //读取文件夹
	if err != nil {
		return files, errors.New("文件夹不可读取")
	}
	for _, fi := range read { //循环每个文件或者文件夹
		fulldir := path + "\\" + fi.Name() //构造新的路径
		if fi.IsDir() {
			files = append(files, fulldir)
			files, _ = GetAll(fulldir, files)
		} else {
			files = append(files, fulldir)
		}
	}
	return files, nil
}

func main() {
	path := "D:\\project\\yuge"
	files := []string{}
	files, _ = GetAll(path, files)
	for i := 0; i < len(files); i++ {
		fmt.Println(files[i])
	}
}
