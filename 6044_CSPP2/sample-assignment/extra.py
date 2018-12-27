
def validInput(data):
    if len(data) != 81:
        raise Exception("Invalid input")
    elif '.' not in data:
        raise Exception("Given sudoku is solved")



def validSudoku(sudoku):
    for x in range(0,9):
        var = getRow(x, sudoku)
        if len(set(var)) != len(var):
            raise Exception("Invalid Sudoku:Duplicate values")   
            # print("Invalid Sudoku:Duplicate values")
        colVar = getCol(x, sudoku)
        if len(set(colVar)) != len(colVar):
            raise Exception("Invalid Sudoku:Duplicate values")   
            # print("Invalid Sudoku:Duplicate values")



def getRow(cell, sudoku):
    row = []
    for x in sudoku[cell]:
        if x != '.':
            row.append(x)
    # print(row)
    return row




def getCol(cell, sudoku):
    col = []
    for row in sudoku:
        if row[cell] != '.':
            col.append(row[cell])
    return col




def getSubGrid(a, b, sudoku):
    subGrid = []
    var1 = False
    for i in range(0, 3):
        for j in range(0, 3):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid
    

    subGrid = []
    for i in range(0, 3):
        for j in range(3, 6):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid

    subGrid = []
    for i in range(0, 3):
        for j in range(6, 9):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid
    

    subGrid = []
    for i in range(3, 6):
        for j in range(0, 3):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid


    subGrid = []
    for i in range(3, 6):
        for j in range(3, 6):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid

    subGrid = []
    for i in range(3, 6):
        for j in range(6, 9):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid    

    subGrid = []    
    for i in range(6, 9):
        for j in range(0, 3):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid

    subGrid = []     
    for i in range(6, 9):
        for j in range(3, 6):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid

    subGrid = []
    for i in range(6, 9):
        for j in range(6, 9):
            if i == a and j == b:   
                var1 = True
            subGrid.append(sudoku[i][j])
    if var1 == True:
        return subGrid




def possibilites(sudoku):
    for i in range(len(sudoku)):
        for j in range(len(sudoku[0])):
            if sudoku[i][j] == ".":
                rowVal = getRow(i, sudoku)
                colVal = getCol(j, sudoku)
                gridVal = getSubGrid(i, j, sudoku)
                # storing all the values of the row, col and grid in a new list
                newData = rowVal + colVal + gridVal
                string = ''
                for l in range(1,10):
                    if str(l) not in newData:
                        string += str(l)
                print(string)




def main():
    data1 = input()
    data = list(data1)
    # print(data)
    i = 0
    sudoku = []

    try:
        validInput(data1)
        while(i < 81):
            row = []
            for k in range(0,9):
                row.append(data[i])
                i = i + 1
            sudoku.append(row)
        validSudoku(sudoku)
        possibilites(sudoku)
    except Exception as e:
        print(e)
    # print(sudoku)

if __name__ == '__main__':
    main()
