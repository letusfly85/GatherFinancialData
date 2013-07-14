def toCamelCase(str) {
	buf = ""
	pre_buf = ""
	str.each {
		if (pre_buf == "_") {
			buf += it.toUpperCase()

		} else if (it == "_") {
			null

		} else {
			buf += it.toLowerCase()
		}

		pre_buf = it
	}

	return buf
}

def getFieldType(str) {
	def fieldType = ""

	if (str.toLowerCase() =~ /char/) {
		fieldType = "String"
	} else {
		fieldType = "int"
	
	}

	return fieldType
}


def idx = 1
new File("target.txt").each {
	ary = it.replaceFirst(/([\s])/,"").replaceAll(/([|])/,"").
		split(/([\s]+)/)

	def fieldName = toCamelCase(ary[0])
	def fieldType = getFieldType(ary[1])

	//println (fieldType + "\t" + fieldName)
	println ("stmt.setString(" + idx + ", entity." + fieldName + ")")
	idx += 1
}
